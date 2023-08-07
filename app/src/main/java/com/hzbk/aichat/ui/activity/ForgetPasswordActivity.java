package com.hzbk.aichat.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.entity.BaseBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.other.AppConfig;
import com.hzbk.aichat.util.GsonUtil;
import com.hzbk.aichat.util.TimeCountUtil;

public class ForgetPasswordActivity extends AppActivity {
    private LModule module = new LModule();
    private TimeCountUtil mTimeCountUtil;
    private EditText et_phone, et_code, et_password_1, et_password_2;
    private TextView tv_code, btnSubmit;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void initView() {
        et_phone = findViewById(R.id.et_phone);
        et_password_1 = findViewById(R.id.et_password_1);
        et_password_2 = findViewById(R.id.et_password_2);
        et_code = findViewById(R.id.et_code);
        btnSubmit = findViewById(R.id.btnSubmit);
        tv_code = findViewById(R.id.tv_code);
        tv_code.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                if (!phone().matches(AppConfig.RegexMOBILE)) {
                    toast("请输入有效的手机号码");
                    return;
                }
                getInvitationCode(phone());
                break;
            case R.id.btnSubmit:
                if (!phone().matches(AppConfig.RegexMOBILE)) {
                    toast("请输入有效的手机号码");
                    return;
                }
                if (code().isEmpty()) {
                    toast("请输入有效的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(getCode())) {
                    toast("验证码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(password1())) {
                    toast("密码不能为空");
                    return;
                }       if (TextUtils.isEmpty(password2())) {
                    toast("确认密码不能为空");
                    return;
                }
                if (!password1().equals(password2())) {
                    toast("密码输入不一致");
                    return;
                }

                checkVcode(phone(),password1(),code());
                break;
        }
    }

    private void getInvitationCode(String phone) {
        showDialog("发送中...");
        module.getSendCode(phone, new MCallback() {
            @Override
            public void onSuccess(String response) {
                hideDialog();
                BaseBean bean = GsonUtil.GsonToBean(response, BaseBean.class);
                toast(bean.getMsg());
                mTimeCountUtil = new TimeCountUtil(tv_code, 60000, 1000);
                mTimeCountUtil.start();
            }

            @Override
            public void onError(String msg, String status) {
                hideDialog();
                toast(msg);
            }

            @Override
            public void onFailed(Exception e) {
                hideDialog();
                toast(e.getMessage());
            }
        });

    }

    private void checkVcode(String phone, String password, String code) {
        showDialog("发送中...");
        module.passwordReset(phone,password,code, new MCallback() {
            @Override
            public void onSuccess(String response) {
                hideDialog();
                BaseBean bean = GsonUtil.GsonToBean(response, BaseBean.class);
                toast(bean.getMsg());
            }

            @Override
            public void onError(String msg, String status) {
                hideDialog();
                toast(msg);
            }

            @Override
            public void onFailed(Exception e) {
                hideDialog();
                toast(e.getMessage());
            }
        });


    }

    @Override
    protected void initData() {

    }

    private String password2() {
        return et_password_2.getText().toString().trim();
    }

    private String password1() {
        return et_password_1.getText().toString().trim();
    }
    private String getCode() {
        return et_code.getText().toString().trim();
    }

    private String phone() {
        return et_phone.getText().toString().trim();
    }

    private String code() {
        return et_code.getText().toString().trim();
    }

}