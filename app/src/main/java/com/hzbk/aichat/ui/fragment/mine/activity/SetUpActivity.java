package com.hzbk.aichat.ui.fragment.mine.activity;


import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.dialog.ShowDialog;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.manager.ActivityManager;
import com.hzbk.aichat.other.SpBean;
import com.hzbk.aichat.ui.activity.LoginActivity;
import com.hzbk.aichat.util.SPUtils;

import cc.taylorzhang.singleclick.SingleClickUtil;

public class SetUpActivity extends AppActivity implements View.OnClickListener {
    private static final String TAG = "SetUpActivity";
    private TextView exitApp;
    private RelativeLayout  rlModifyPassword, rlCheckUpdate;
    private final LModule module = new LModule();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected void initView() {
        exitApp = findViewById(R.id.exit_app);

        rlModifyPassword = findViewById(R.id.rl_modify_password);
        rlCheckUpdate = findViewById(R.id.rl_check_update);
        exitApp.setOnClickListener(this);
        SingleClickUtil.onSingleClick(rlModifyPassword, v -> {//重置密码
            startActivity(ModifyPasswordActivity.class);
        });
        SingleClickUtil.onSingleClick(rlCheckUpdate, v -> {//检查更新
            startActivity(CheckUpdateActivity.class);
        });
        SingleClickUtil.onSingleClick(exitApp, v -> {//退出登录
            new ShowDialog.Builder(getActivity())
                    .setTitle("确认退出登录?")
                    .setListener(new ShowDialog.OnListener() {
                        @Override
                        public void onClick() {
                            SPUtils.getInstance().put(SpBean.Login, false);
                            finish();
                            ActivityManager.getInstance().finishAllActivities();
                            startActivity(LoginActivity.class);
                        }
                    }).show();
        });
    }


    @Override
    protected void initData() {
    }


}