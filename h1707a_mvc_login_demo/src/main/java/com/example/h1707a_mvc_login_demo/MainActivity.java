package com.example.h1707a_mvc_login_demo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import h1707a_mvc_login_demo.model.NetWorkUtil;
import h1707a_mvc_login_demo.model.User;

public class MainActivity extends AppCompatActivity {
    private EditText met_name, met_pwd;
    private ProgressDialog mProgressDialog;
    private String strName, strPwd;
    public RunOnUiThreadAndToastListenner mListenner;
    private Button mBtn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressDialog = new ProgressDialog(MainActivity.this);
        met_name = (EditText) findViewById(R.id.et_name);
        met_pwd = (EditText) findViewById(R.id.et_pwd);
        mBtn_click= (Button) findViewById(R.id.btn_login);

        mListenner = new RunOnUiThreadAndToastListenner() {
            @Override
            public void runOnThreadAndToast(User user, final String strResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mProgressDialog.dismiss();
                        Toast.makeText(MainActivity.this, strResult, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
    }

    public void click(View view) {
        strName = met_name.getText().toString().trim();
        strPwd = met_pwd.getText().toString().trim();
        final User user = new User(strName, strPwd);

        if (isCheckUserAndPwd(user)) {
            mProgressDialog.show();
            //访问网络数据 M层
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    if (NetWorkUtil.getNetWorkData(user))
                        mListenner.runOnThreadAndToast(user, user.getUserName() + "欢迎回来");
                    else
                        mListenner.runOnThreadAndToast(user, "登录失败");
                }
            }.start();

        } else {
            Toast.makeText(MainActivity.this, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 判断用户名和密码是否为空
     */
    public boolean isCheckUserAndPwd(User user) {
        if (!TextUtils.isEmpty(user.getUserName()) &&
                !TextUtils.isEmpty(user.getUserPwd()))
            return true;
        else
            return false;
    }


}
