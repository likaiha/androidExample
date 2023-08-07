package com.hzbk.aichat.ui.fragment.mine.activity;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;

//修改密码
public class ModifyPasswordActivity extends AppActivity implements View.OnClickListener {

    private LModule module = new LModule();
    private EditText etOldPass, etNewPass, etNewConPass;
    private TextView tvSave;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_password;
    }

    @Override
    protected void initView() {
        etOldPass = findViewById(R.id.et_old_password);//原始密码
        etNewPass = findViewById(R.id.et_password);//新密码
        etNewConPass = findViewById(R.id.et_confirm_password);//确认新密码
        tvSave = findViewById(R.id.tv_save);//保存

        tvSave.setOnClickListener(this);
    }

    @Override
    protected void initData() {}

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_save:
                if("".equals(getOldPass())){
                    toast("请输入原始密码");
                    return;
                }
                if("".equals(getNewPass())){
                    toast("请输入新密码");
                    return;
                }
                if(getNewPass().length() < 6){
                    toast("密码长度至少为6位");
                    return;
                }
                if("".equals(getConfirmPass())){
                    toast("请输入确认密码");
                    return;
                }
                if(!getNewPass().equals(getConfirmPass())){
                    toast("两次密码输入不一致");
                    return;
                }
                modifyPassword();
                break;
        }
    }

    //修改密码
    private void modifyPassword() {
        showDialog("发送中...");
        module.passwordChange(getOldPass(),getNewPass(),getConfirmPass(), new MCallback() {
            @Override
            public void onSuccess(String response) {
                toast("密码重置成功");
                hideDialog();
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

    //旧密码
    private String getOldPass() {
        return etOldPass.getText().toString().trim();
    }
    //新密码
    private String getNewPass() {
        return etNewPass.getText().toString().trim();
    }
    //确认密码
    private String getConfirmPass(){
        return etNewConPass.getText().toString().trim();
    }
}