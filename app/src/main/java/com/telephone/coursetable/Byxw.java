package com.telephone.coursetable;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.telephone.coursetable.Database.PersonInfoDao;
import com.telephone.coursetable.Database.TermInfo;
import com.telephone.coursetable.Database.TermInfoDao;
import com.telephone.coursetable.Database.UserDao;
import com.telephone.coursetable.Fetch.LAN;
import com.telephone.coursetable.Gson.GraduationDegreeEvaluation;
import com.telephone.coursetable.Gson.GraduationDegreeEvaluation_s;
import com.telephone.coursetable.Http.Get;
import com.telephone.coursetable.Http.HttpConnectionAndCode;
import com.telephone.coursetable.Http.Post;
import com.telephone.coursetable.LogMe.LogMe;
import com.telephone.coursetable.OCR.OCR;

import java.util.List;

public class Byxw {

    private static final Class<TeacherEvaluationPanel> byxw_class = TeacherEvaluationPanel.class;

    public static boolean Byxw_Query(@NonNull AppCompatActivity c){

        byxw_class.cast(c).prepare_start();

        UserDao udao = MyApp.getCurrentAppDB().userDao();
        PersonInfoDao pdao = MyApp.getCurrentAppDB().personInfoDao();
        TermInfoDao tdao = MyApp.getCurrentAppDB().termInfoDao();
        String id = udao.getActivatedUser().get(0).username;
        String pwd = udao.getActivatedUser().get(0).password;
        String cookie = "";
        while (true) {
            HttpConnectionAndCode hcac = LAN.checkcode(c);
            if (hcac.obj == null) {
                end(c, "登录失败，请检查校园网连接后重试。");
                return true;
            }

            cookie = hcac.cookie;
            StringBuilder stringBuilder = new StringBuilder(cookie);
            Bitmap bitmap = (Bitmap) hcac.obj;
            String ckcode = OCR.getTextFromBitmap(c, bitmap, MyApp.ocr_lang_code);
            HttpConnectionAndCode login_res = Login.login(c, id, pwd, ckcode, cookie, stringBuilder);
            if (login_res.code != 0) {
                if (login_res.code == -6) {
                    if (login_res.comment.contains("验证码")) {
                        continue;
                    } else {
                        end(c, "登录失败，密码错误。请更新重新登录以您的学分制系统密码。");
                        return true;
                    }
                } else {
                    end(c, "登录失败，请检查校园网连接后重试。");
                    return true;
                }
            }
            cookie = stringBuilder.toString();
            break;
        }

        String referer = "http://172.16.13.22/Login/MainDesktop";
        String user_agent = c.getResources().getString(R.string.user_agent);

        HttpConnectionAndCode money_res = Post.post(
                "http://172.16.13.22/student/genstufee/",
                null,
                user_agent,
                referer,
                "ctype=byyqxf&stid=" + id + "&grade=" + pdao.getGrade().get(0) + "&spno=" + pdao.selectAll().get(0).spno,
                cookie,
                "}",
                null,
                "\"success\":true",
                null,
                null,
                null
        );
        if (money_res.code != 0){
            end(c, "财务费用更新失败。请检查校园网连接后重试。");
            return true;
        }
        List<TermInfo> termlist = tdao.selectAll();
        for(TermInfo term : termlist){
            HttpConnectionAndCode make_term_res = Post.post(
                    "http://172.16.13.22/student/genstuby/" + term.term,
                    null,
                    user_agent,
                    referer,
                    "ctype=byyqxf&stid=" + id + "&grade=" + pdao.getGrade().get(0) + "&spno=" + pdao.selectAll().get(0).spno,
                    cookie,
                    "}",
                    null,
                    "\"success\":true",
                    null,
                    null,
                    null
            );
            if (make_term_res.code != 0){
                end(c, "毕业采集失败。请检查校园网连接后重试。");
                return true;
            }
        }
        HttpConnectionAndCode query_res = Get.get(
                "http://172.16.13.22/student/getbyxw",
                null,
                user_agent,
                referer,
                cookie,
                "]}",
                null,
                "\"success\":true",
                null,
                null,
                null,
                30000
        );
        if (query_res.code != 0){
            end(c, "查询失败。请检查校园网连接后重试。");
            return true;
        }
        GraduationDegreeEvaluation data = new Gson().fromJson(query_res.comment, GraduationDegreeEvaluation_s.class).getData().get(0);
        printlog(c, "等级考试成绩：" + data.getCet() + "：" + data.getCetshow());
        printlog(c, "学分绩：" + data.getXfj());
        printlog(c, "外语平均分：" + data.getFpjf());
        printlog(c, "备注：" + data.getComm());
        end(c, "");
        return true;
    }

    public static void printlog(@NonNull AppCompatActivity c,String str){
        byxw_class.cast(c).print(str);
    }

    public static void end(@NonNull AppCompatActivity c, String str){
        printlog(c, str);
        byxw_class.cast(c).cleanup_end();
    }

}
