package com.telephone.coursetable.GradePoint;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.telephone.coursetable.Http.Get;
import com.telephone.coursetable.Http.HttpConnectionAndCode;
import com.telephone.coursetable.Http.Post;
import com.telephone.coursetable.Login;
import com.telephone.coursetable.Login_vpn;
import com.telephone.coursetable.MyApp;
import com.telephone.coursetable.MyException.Exception302;
import com.telephone.coursetable.MyException.ExceptionNetworkError;
import com.telephone.coursetable.MyException.ExceptionUnknown;
import com.telephone.coursetable.MyException.ExceptionWrongUserOrPassword;
import com.telephone.coursetable.R;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GradePoint_Test {

    //学分绩学年
    public static String grade_year_html_lan(Context c, String cookie) {
        Resources r = c.getResources();
        HttpConnectionAndCode gpc = Get.get(
                "http://172.16.1.99/student/public/login.asp",
                null,
                r.getString(R.string.user_agent),
                "http://172.16.1.99/student/public/mnall.asp",
                cookie,
                null,
                null,
                null,
                null,
                false,
                null,
                null
        );
        if(gpc.code == 0) {
            return gpc.comment;
        }
        return null;
    }

    //学分绩
    public static String grade_point_html_lan(Context c, String cookie, String syear){
        Resources r = c.getResources();
        HttpConnectionAndCode gpc = Post.post(
                "http://172.16.1.99/student/xuefenji.asp",
                null,
                r.getString(R.string.user_agent),
                "http://172.16.1.99/student/xuefenji.asp",
                "xn=" + syear + "&lwPageSize=1000&lwBtnquery=%B2%E9%D1%AF",
                cookie,
                null,
                null,
                null,
                null,
                false,
                null
        );
        if(gpc.code == 0 && !gpc.comment.isEmpty()){
            String html = gpc.comment;
            Elements score_nodes = Jsoup.parse(html).select("html > body > table > tbody > tr > td > table > tbody > tr > td > B > font");
            if (score_nodes.isEmpty()){
                return null;
            }else if (score_nodes.get(0).ownText().isEmpty()){
                String id = Jsoup.parse(html).select("html > body > table > tbody > tr > td > table > tbody > tr > th").get(4).ownText();
                if (id.isEmpty()){
                    com.telephone.coursetable.LogMe.LogMe.e("grade point", "regain point");
                    return grade_point_html_lan(c, cookie, syear);
                }else {
                    return "";
                }
            }else {
                return score_nodes.get(0).ownText();
            }
        }
        return null;
    }


    //学分系统登录后
    //处理得到的html文本
    public static List<Map.Entry<String, String>> grade_point_array(Context c, String sid, String cookie){

        List<Map.Entry<String, String>> gp_arr = new ArrayList<>();
        String xml;
        String sscore;
        Elements years_xml;
        Document doc;

        String[] syears;
        String sy;
        String syear = "";
        sy = sid.substring(0,2);

        xml = grade_year_html_lan(c, cookie);
        if (xml==null) return null;
        doc = Jsoup.parse( xml );
        years_xml = doc.select("html > body > form > table > tbody > tr > td > select > option");
        if (years_xml.size()==0) return null;
        for ( int i = 0 ; i < years_xml.size() ; i++ ) {
            Element year = years_xml.get(i);
            syear = syear + year.ownText();
            if (year.ownText().contains(sy)) {
                break;
            }
            syear = syear + ",";
        }

        syears = syear.split(",");
        for ( String year : syears ) {
            sscore = grade_point_html_lan(c, cookie, year);
            com.telephone.coursetable.LogMe.LogMe.e("grade point", "year = " + year + " point = " + sscore);
            if (sscore == null) return null;
            if (year.isEmpty()) year = "入学至今";
            gp_arr.add(com.telephone.coursetable.Database.Methods.Methods.entry(sscore, year));
        }
        gp_arr.add(gp_arr.get(0));
        gp_arr.remove(0);

        return gp_arr;
    }

    public static HttpConnectionAndCode outside_login_test(Context c, final String sid, final String pwd){
        final String NAME = "outside_login_test()";
        Resources r = c.getResources();
        String body = "username=" + sid + "&passwd=" + pwd + "&login=%B5%C7%A1%A1%C2%BC";
        com.telephone.coursetable.LogMe.LogMe.e(NAME + " " + "body", body);
        HttpConnectionAndCode login_res = com.telephone.coursetable.Http.Post.post(
                r.getString(R.string.lan_outside_login_url),
                null,
                r.getString(R.string.user_agent),
                r.getString(R.string.lan_outside_login_referer),
                body,
                null,
                null,
                r.getString(R.string.cookie_delimiter),
                null,
                null,
                false,
                null
        );
        if (login_res.code == -7){
            login_res.code = 0;
            com.telephone.coursetable.LogMe.LogMe.e(NAME + " " + "login status", "success");
        }else {
            if (login_res.code == 0){
                login_res.code = -6;
            }
            com.telephone.coursetable.LogMe.LogMe.e(NAME + " " + "login status", "fail" + " code: " + login_res.code);
        }
        return login_res;

    }

    public static Get_grade_points_array lan_get_grade_point_array( Context c, String sid, String aaw_pwd ) {
        HttpConnectionAndCode login_res = outside_login_test(c, sid, aaw_pwd);
        Resources resources = c.getResources();
        if ( login_res.code!=0 ) return new Get_grade_points_array(login_res.code);
        List<Map.Entry<String, String>> grade_point = grade_point_array(c, sid, login_res.cookie);
        if ( grade_point==null ) return new Get_grade_points_array(resources.getString(R.string.wan_login_vpn_network_error_exception));
        return new Get_grade_points_array(grade_point);
    }

}
