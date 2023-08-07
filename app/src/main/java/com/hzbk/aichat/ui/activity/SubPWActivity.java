package com.hzbk.aichat.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.other.AppConfig;

public class SubPWActivity extends AppActivity {
    private LModule module = new LModule();
    private EditText et_password_1, et_password_2;
    private TextView btnSubmit;

    public static void start(Context context, String phone) {
        Intent intent = new Intent(context, SubPWActivity.class);
        intent.putExtra(AppConfig.PHONE, phone);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sub_pwactivity;
    }

    @Override
    protected void initView() {
        et_password_1 = findViewById(R.id.et_password_1);
        et_password_2 = findViewById(R.id.et_password_2);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {
            if (pw1().isEmpty()) {
                toast("登录密码不能为空");
                return;
            }
            if (pw2().isEmpty()) {
                toast("重复密码不能为空");
                return;
            }
            if (!pw1().equals(pw2())) {
                toast("输入密码不一致");
                return;
            }

            updatePassword();
        });

    }

    private void updatePassword() {

//        module.updatePassword(getString(AppConfig.PHONE), MD5Utils.encrypt(new StringBuffer(MD5Utils.encrypt(pw1())).reverse().toString())
//                , MD5Utils.encrypt(new StringBuffer(MD5Utils.encrypt(pw2())).reverse().toString()), new MCallback() {
//                    @Override
//                    public void onSuccess(String response) {
//                        toast("设置登录密码成功");
//                        finish();
//                    }
//
//                    @Override
//                    public void onError(String msg, String status) {
//
//                    }
//
//                    @Override
//                    public void onFailed(Exception e) {
//                        hideDialog();
//                    }
//                });

    }

    @Override
    protected void initData() {

    }

    private String pw1() {
        return et_password_1.getText().toString().trim();
    }

    private String pw2() {
        return et_password_2.getText().toString().trim();
    }
}