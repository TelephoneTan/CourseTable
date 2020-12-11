package com.telephone.coursetable.GradePoint;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.telephone.coursetable.Database.AppDatabase;
import com.telephone.coursetable.Database.User;
import com.telephone.coursetable.Database.UserDao;
import com.telephone.coursetable.FunctionMenu;
import com.telephone.coursetable.Login;
import com.telephone.coursetable.Login_vpn;
import com.telephone.coursetable.MainActivity;
import com.telephone.coursetable.MyApp;
import com.telephone.coursetable.R;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GradePointActivity extends AppCompatActivity {

    private String sid;
    private String aaw_pwd;
    private ExpandableListView menu_listf;
    private ProgressBar progressBar;
    private TextView tvToast;
    private List<Map.Entry<String, List<Map.Entry<String, String>>>> points_list;
    private AppDatabase appDatabase;
    private UserDao udao;
    private List<User> list_user;
    private User user;
    private int looptimes;

    private volatile boolean visible = true;
    private volatile Intent outdated = null;

    synchronized public boolean setOutdated(){
        if (visible) return false;
        outdated = new Intent(this, MainActivity.class);
        return true;
    }

    synchronized public void hide(){
        visible = false;
    }

    synchronized public void show(){
        visible = true;
        if (outdated != null){
            startActivity(outdated);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        show();
    }

    @Override
    protected void onPause() {
        hide();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, FunctionMenu.class));
    }

    @Override
    protected void onDestroy() {
        MyApp.clearRunningActivity(this);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.setRunning_activity(MyApp.RunningActivity.GRADE_POINTS);
        MyApp.setRunning_activity_pointer(this);
        setContentView(R.layout.activity_gradepoint);

        menu_listf = findViewById(R.id.grade_points_list);
        progressBar = findViewById(R.id.progressBar2);
        tvToast = findViewById(R.id.grade_points_toast);
        points_list = new LinkedList<>();

        progressBar.setVisibility(View.INVISIBLE);
        looptimes = 0;

        Create_dialog_asking_pwd();

        //刷新
        menu_listf.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                com.telephone.coursetable.LogMe.LogMe.e("grade point list", "clicked");
                dosearch();
                return false;
            }
        });

    }

    private void dosearch() {
        final String NAME = "GradePointActivity.dosearch()";
        Processing_error(false);

        new Thread(()->{
            appDatabase = MyApp.getCurrentAppDB();
            udao = appDatabase.userDao();
            list_user = udao.getActivatedUser();
            user = list_user.get(0);
            sid = user.username;

            points_list = new LinkedList<>();

            runOnUiThread(()->{ progressBar.setVisibility(View.VISIBLE); });

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        if ( points_list.size() == 0 ) {
                            runOnUiThread(()->{ tvToast.setVisibility(View.VISIBLE); });
                        }
                    } catch (InterruptedException e) {
                        // Restore interrupt status.
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();

            Get_grade_points_array grade_point_array = GradePoint_Test.lan_get_grade_point_array(GradePointActivity.this, sid, aaw_pwd);
            //密码错误进入判断
            if (grade_point_array.code != 0) {
                runOnUiThread(()->{
                    Processing_error(true);
                    if (grade_point_array.code == -6) {
                        Toast.makeText(GradePointActivity.this, getString(R.string.wan_snackbar_outside_test_login_fail), Toast.LENGTH_LONG).show();
                        //密码不正确，需要重新弹出对话框
                        Create_dialog_asking_pwd();
                    }else {
                        Toast.makeText(GradePointActivity.this, getString(R.string.wan_login_vpn_network_error), Toast.LENGTH_LONG).show();
                        //网络异常，需要重新查询
                        Log.e(NAME, "again!");
                    }
                });
            }else if (grade_point_array.message!=null) {
                Toast.makeText(GradePointActivity.this, getString(R.string.wan_login_vpn_network_error), Toast.LENGTH_LONG).show();
                //抓取数据过程中失败，重新抓取？
                Log.e(NAME, "again!");
            }
            runOnUiThread(()->Processing_correct(grade_point_array.grade_points_array));
        }).start();
    }

    private void Create_dialog_asking_pwd(){

        View asking_pwd = getLayoutInflater().inflate(R.layout.dialog_ask_pwd_xfj, null);

        AlertDialog dialog_ask_pwd = Login.getAlertDialog(this,"",
                (dialogInterface, i) -> {
                    aaw_pwd = ((EditText)asking_pwd.findViewById(R.id.dialog_pwd_input)).getText().toString();
                    dosearch();
                },
                (dialogInterface, i) -> {
                    startActivity(new Intent(this, MainActivity.class));
                },
                asking_pwd,
                "登入教务网站", null, null
        );
        runOnUiThread(()->{dialog_ask_pwd.show();});

    }


    private void Processing_error(boolean clickable) {
        tvToast.setVisibility(View.INVISIBLE);
        List<Map.Entry<String, String>> Grade_point_array = new LinkedList<>();
        points_list.add(com.telephone.coursetable.Database.Methods.Methods.entry("学分绩", Grade_point_array));
        progressBar.setVisibility(View.INVISIBLE);
        menu_listf.setAdapter(new GradePointAdapter(GradePointActivity.this, points_list, true, menu_listf));
        menu_listf.setGroupIndicator(null);
        menu_listf.setEnabled(clickable);
    }

    private void Processing_correct(List<Map.Entry<String, String>> sublist) {
        tvToast.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        points_list.add(com.telephone.coursetable.Database.Methods.Methods.entry("学分绩", sublist));
        menu_listf.setAdapter(new GradePointAdapter(GradePointActivity.this, points_list, true, menu_listf));
        menu_listf.setGroupIndicator(null);
        menu_listf.expandGroup(0);
        menu_listf.setEnabled(true);
    }

}
