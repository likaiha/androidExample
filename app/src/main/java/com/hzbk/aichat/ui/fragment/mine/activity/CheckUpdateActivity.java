package com.hzbk.aichat.ui.fragment.mine.activity;

import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.dialog.CheckVersionDialog;
import com.hzbk.aichat.entity.CheckVersionBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.util.GsonUtil;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.Utils;
import com.king.app.dialog.AppDialog;
import com.king.app.dialog.AppDialogConfig;
import com.king.app.updater.AppUpdater;
import com.king.app.updater.callback.AppUpdateCallback;

import java.io.File;
//检查更新
public class CheckUpdateActivity extends AppActivity {
    private LModule module = new LModule();
    private AppUpdater mAppUpdater;
    private TextView tvVersion, tvUpdate;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_update;
    }

    @Override
    protected void initView() {
        tvVersion = findViewById(R.id.tv_version);
        tvUpdate = findViewById(R.id.tv_update);

        tvVersion.setText("当前版本号:" + Utils.getVersionName(getActivity()));
        tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getCheckVersion();
            }
        });
    }

    @Override
    protected void initData() {

    }

    //检查更新
    private void getCheckVersion() {
        showDialog("更新中......");
        module.checkApp(Utils.getVersionCode(getApplication()) + "", new MCallback() {
            @Override
            public void onSuccess(String response) {
                hideDialog();
                LogUtils.e("checkApp", "checkApp  - getCategoryPostLists-- " + response);
                CheckVersionBean checkVersionBean = GsonUtil.GsonToBean(response, CheckVersionBean.class);
                CheckVersionBean.DataDat data = checkVersionBean.getData();
                down(data.getDownload_url(), data.getDescription(), data.getVersion_num());//下载链接 描述
            }

            @Override
            public void onError(String msg, String status) {
                hideDialog();
                toast(msg);
            }

            @Override
            public void onFailed(Exception e) {
                hideDialog();
            }
        });


    }

    private void down(String downloadUrl, String description, String version_num) {
        new CheckVersionDialog.Builder(getActivity())
                .setVersion("V" + version_num)
                .setDescription(description)
                .setListener(new CheckVersionDialog.OnListener() {
                    @Override
                    public void onClick() {
                        mAppUpdater = new AppUpdater.Builder()
                                .setUrl(downloadUrl)
                                .build(getApplication())
                                .setUpdateCallback(new AppUpdateCallback() {
                                    @Override
                                    public void onStart(String url) {
                                        super.onStart(url);
                                        // 模仿系统自带的横幅通知效果
                                        AppDialogConfig config = new AppDialogConfig(getActivity(), R.layout.dialog_heads_up);
                                        config.setStyleId(R.style.app_dialog_heads_up)
                                                .setWidthRatio(0.95f)
                                                .setGravity(Gravity.TOP);
                                        AppDialog.INSTANCE.showDialog(getActivity(), config);
                                        new CountDownTimer(2000, 500) {

                                            @Override
                                            public void onTick(long millisUntilFinished) {

                                            }

                                            @Override
                                            public void onFinish() {
                                                AppDialog.INSTANCE.dismissDialog();
                                            }
                                        }.start();
                                    }

                                    @Override
                                    public void onProgress(long progress, long total, boolean isChange) {

                                    }

                                    @Override
                                    public void onFinish(File file) {
                                        tvVersion.setText("当前版本号:" + version_num);
                                        toast("下载完成");
                                    }
                                });
                        mAppUpdater.start();
                    }
                }).show();
    }
}
