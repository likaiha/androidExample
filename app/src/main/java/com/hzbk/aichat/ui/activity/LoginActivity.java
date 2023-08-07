package com.hzbk.aichat.ui.activity;


import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.entity.BaseBean;
import com.hzbk.aichat.entity.LoginBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.other.AppConfig;
import com.hzbk.aichat.other.SpBean;
import com.hzbk.aichat.util.GsonUtil;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.SPUtils;
import com.hzbk.aichat.util.TimeCountUtil;

import cc.taylorzhang.singleclick.SingleClickUtil;

public class LoginActivity extends AppActivity {

    private RadioButton rb_agree1;
    private EditText et_phone, et_password, code;
    private TextView tv_register;
    private TextView tvPrivacy;
    private TextView tvAgreement;
    private TextView text1;
    private TextView text2;
    private TextView tv_code;
    private boolean aAgreeBoolean = false;
    private LModule module = new LModule();
    private int item = 1;
    private TimeCountUtil mTimeCountUtil;

    private LinearLayout llPass, llCode, ll1, ll2;
    private TextView tvForget;
    private Button btn_login;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        code = findViewById(R.id.code);
        tv_code = findViewById(R.id.tv_code);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        et_password = findViewById(R.id.et_password);
        tv_register = findViewById(R.id.tv_register);
        tvAgreement = findViewById(R.id.tvAgreement);
        tvPrivacy = findViewById(R.id.tvPrivacy);
        btn_login = findViewById(R.id.btn_login);
        rb_agree1 = findViewById(R.id.rb_agree1);
        et_phone = findViewById(R.id.et_phone);
        tvForget = findViewById(R.id.tvForget);
        llCode = findViewById(R.id.llCode);
        llPass = findViewById(R.id.llPass);
        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        tv_register.setOnClickListener(this);
        llPass.setOnClickListener(this);
        llCode.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        tvPrivacy.setOnClickListener(this);
        tvForget.setOnClickListener(this);
        tvAgreement.setOnClickListener(this);
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(HomeActivity.class);
//            }
//        });
        SingleClickUtil.onSingleClick(tv_code, v -> {
            if (!getPhone().matches(AppConfig.RegexMOBILE)) {
                toast("请输入有效的手机号码");
                return;
            }
            getInvitationCode(getPhone());
        });
        SingleClickUtil.onSingleClick(tvAgreement, v -> {//协议
//            WebViewActivity.start(getActivity(), "1");
        });
        SingleClickUtil.onSingleClick(tvPrivacy, v -> {//政策
//            WebViewActivity.start(getActivity(), "2");
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
            case R.id.llPass://
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.GONE);
                text1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sp_16));
                text1.setTextColor(getContext().getColor(R.color.color_ae2b2b));
                text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sp_14));
                text2.setTextColor(getContext().getColor(R.color.color_333333));
                item = 1;
                break;
            case R.id.llCode://
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.VISIBLE);
                text1.setTextColor(getContext().getColor(R.color.color_333333));
                text1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sp_14));
                text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sp_16));
                text2.setTextColor(getContext().getColor(R.color.color_ae2b2b));
                item = 2;
                break;
            case R.id.btn_login://登录
                if (item == 1) {//密码
//                    initLogin();
                }
                if (item == 2) {//验证码
//                    initCode();
                }
                break;
            case R.id.tv_register://注册
                startActivity(RegisterActivity.class);
                break;
            case R.id.tvAgreement://
//                WebViewActivity.start(getActivity(), "1");
//                UserXieYiActivity.start(getActivity());
                break;
            case R.id.tvPrivacy://
//                WebViewActivity.start(getActivity(), "2");
//                UserYinSiActivity.start(getActivity());
                break;
            case R.id.tvForget://
                startActivity(ForgetPasswordActivity.class);
                break;
        }

    }

    private void initCode() {
        if (!getPhone().matches(AppConfig.RegexMOBILE)) {
            toast("请输入有效的手机号码");
            return;
        }
        if (!aAgreeBoolean) {
            toast("请同意用户协议隐私政策");
            return;
        }
        showDialog("登录中...");
//        String pass = new StringBuffer(MD5Utils.encrypt(getPW())).reverse().toString();
        module.codeLogin(getPhone(), getCode(), new MCallback() {
            @Override
            public void onSuccess(String response) {
                hideDialog();
                LogUtils.e("LoginActivity ", "LoginActivity - login   - " + response);
                LoginBean loginBean = GsonUtil.GsonToBean(response, LoginBean.class);
//
                String token = loginBean.getData().getToken();
                SPUtils.getInstance().put(SpBean.Token, token);
                SPUtils.getInstance().put(SpBean.Login, true);
                LogUtils.e(" LoginActivity ", "LoginActivity  Login --> " + SPUtils.getInstance().getBoolean(SpBean.Login));
                startActivity(HomeActivity.class);
                finish();

            }

            @Override
            public void onError(String msg, String status) {
                hideDialog();
                toast(msg);
            }

            @Override
            public void onFailed(Exception e) {
                toast(e.getMessage());
                hideDialog();
            }
        });


    }

    private void initLogin() {
        if (!getPhone().matches(AppConfig.RegexMOBILE)) {
            toast("请输入有效的手机号码");
            return;
        }
        if (!aAgreeBoolean) {
            toast("请同意用户协议隐私政策");
            return;
        }
        showDialog("登录中...");
//        String pass = new StringBuffer(MD5Utils.encrypt(getPW())).reverse().toString();
        module.login(getPhone(), getPW(), new MCallback() {
            @Override
            public void onSuccess(String response) {
                hideDialog();
                LogUtils.e("LoginActivity ", "LoginActivity - login   - " + response);
                LoginBean loginBean = GsonUtil.GsonToBean(response, LoginBean.class);
//
                String token = loginBean.getData().getToken();
                SPUtils.getInstance().put(SpBean.Token, token);
                SPUtils.getInstance().put(SpBean.Login, true);
                LogUtils.e(" LoginActivity ", "LoginActivity  Login --> " + SPUtils.getInstance().getBoolean(SpBean.Login));
                startActivity(HomeActivity.class);
                finish();


            }

            @Override
            public void onError(String msg, String status) {
                hideDialog();
                toast(msg);
            }

            @Override
            public void onFailed(Exception e) {
                toast(e.getMessage());
                hideDialog();
            }
        });


    }

    @Override
    protected void initData() {

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
                mTimeCountUtil = new TimeCountUtil(tv_code, 60000, 1000);
                mTimeCountUtil.start();
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

    private String getPW() {
        return et_password.getText().toString().trim();
    }

    private String getCode() {
        return code.getText().toString().trim();
    }

}