package com.hzbk.aichat.ui.activity;


import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.entity.BaseBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.other.AppConfig;
import com.hzbk.aichat.util.GsonUtil;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.TimeCountUtil;

import cc.taylorzhang.singleclick.SingleClickUtil;

public class RegisterActivity extends AppActivity {

    private TextView tv_code;
    private RadioButton rb_agree1;
    private Button btnRegister;
    private EditText et_phone, et_vscode, et_password_1, et_password_2, et_code;
    private LModule module = new LModule();
    private TimeCountUtil mTimeCountUtil;
    private TextView tvPrivacy, tvAgreement, tv_login1;
    private boolean aAgreeBoolean = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

        tv_login1 = findViewById(R.id.tv_login1);
        rb_agree1 = findViewById(R.id.rb_agree1);
        tv_code = findViewById(R.id.tv_code);
        et_phone = findViewById(R.id.et_phone);
        et_vscode = findViewById(R.id.et_vscode);
        btnRegister = findViewById(R.id.btnRegister);
        et_password_1 = findViewById(R.id.et_password_1);
        et_password_2 = findViewById(R.id.et_password_2);
        et_code = findViewById(R.id.et_code);
        tvAgreement = findViewById(R.id.tvAgreement);
        tvPrivacy = findViewById(R.id.tvPrivacy);
        tv_code.setOnClickListener(this);
        tv_login1.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        tvPrivacy.setOnClickListener(this);
        tvAgreement.setOnClickListener(this);
        SingleClickUtil.onSingleClick(tvAgreement, v -> {//协议
            WebViewActivity.start(getActivity(), "1");
        });
        SingleClickUtil.onSingleClick(tvPrivacy, v -> {//政策
            WebViewActivity.start(getActivity(), "2");
        });
        rb_agree1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aAgreeBoolean) {
                    aAgreeBoolean = false;
                    rb_agree1.setChecked(false);
                } else {
                    aAgreeBoolean = true;
                    rb_agree1.setChecked(true);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login1:
                finish();
                break;
            case R.id.btnRegister:

                if (!getPhone().matches(AppConfig.RegexMOBILE)) {
                    toast("请输入有效的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(getVSCode())) {
                    toast("邀请码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(getPassW1())) {
                    toast("密码不能为空");
                    return;
                }
                if (!getPassW1().equals(getPassW2())) {
                    toast("密码输入不一致");
                    return;
                }

                if (TextUtils.isEmpty(getCode())) {
                    toast("验证码不能为空");
                    return;
                }
                if (!aAgreeBoolean) {
                    toast("请同意用户协议隐私政策");
                    return;
                }
                getRegister(getPhone(), getVSCode(), getPassW1(), getCode());

                break;
            case R.id.tv_code:
                if (!getPhone().matches(AppConfig.RegexMOBILE)) {
                    toast("请输入有效的手机号码");
                    return;
                }
                getInvitationCode(getPhone());
                break;
            case R.id.tvAgreement://协议
//                WebViewActivity.start(getActivity(), "1");
//                UserXieYiActivity.start(getActivity());
                break;
            case R.id.tvPrivacy://隐私
//                WebViewActivity.start(getActivity(), "2");
//                UserYinSiActivity.start(getActivity());
                break;
        }
    }

    @Override
    protected void initData() {

    }

    private void getRegister(String phone, String vscode, String password, String code) {
        showDialog("注册中...");
        module.getRegister(phone, vscode, password, code, new MCallback() {
            @Override
            public void onSuccess(String response) {
                LogUtils.e("RegisterActivity ", "RegisterActivity - getRegister - " + response);
                hideDialog();
                BaseBean bean = GsonUtil.GsonToBean(response, BaseBean.class);
                toast(bean.getMsg());
                finish();
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


    private String getPhone() {
        return et_phone.getText().toString().trim();
    }

    private String getVSCode() {
        return et_vscode.getText().toString().trim();
    }

    private String getPassW1() {
        return et_password_1.getText().toString().trim();
    }

    private String getPassW2() {
        return et_password_2.getText().toString().trim();
    }

    private String getCode() {
        return et_code.getText().toString().trim();
    }


}