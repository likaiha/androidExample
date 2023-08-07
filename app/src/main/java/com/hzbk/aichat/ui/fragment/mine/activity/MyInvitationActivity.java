package com.hzbk.aichat.ui.fragment.mine.activity;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.entity.YqUrlBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.other.AppConfig;
import com.hzbk.aichat.util.GsonUtil;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.QRCodeUtil;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import cc.taylorzhang.singleclick.SingleClickUtil;

public class MyInvitationActivity extends AppActivity {
    private LModule module = new LModule();
    private ImageView iv_head;
    private TextView Invitation, btnSV, tvCode;
    private String data;

    public static void start(Context context, String Id) {
        if (TextUtils.isEmpty(Id)) {
            return;
        }
        Intent intent = new Intent(context, MyInvitationActivity.class);
        intent.putExtra(AppConfig.ID, Id);
        context.startActivity(intent);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_invitation;
    }

    @Override
    protected void initView() {
        Objects.requireNonNull(getTitleBar()).setLineVisible(false);
        iv_head = findViewById(R.id.iv_head);
        btnSV = findViewById(R.id.btnSV);
        tvCode = findViewById(R.id.tvCode);
        Invitation = findViewById(R.id.Invitation);


        SingleClickUtil.onSingleClick(Invitation, v -> {//
            if (!data.isEmpty()) {
                copyStr(data);
            }
        });
        SingleClickUtil.onSingleClick(btnSV, v -> {//
            GetPermissions();
        });
    }

    @Override
    protected void initData() {

        tvCode.setText(getString(AppConfig.ID) + "");

    }

    private void GetPermissions() {

        XXPermissions.with(getContext())
                .permission(Permission.MANAGE_EXTERNAL_STORAGE)
                .request(new OnPermissionCallback() {
                    @Override
                    public void onDenied(List<String> permissions, boolean never) {
                        LogUtils.e("  Permissions ", "onDenied -->" +
                                ":  " + permissions.size() + "  " + permissions + " never  " + never);
                    }

                    @Override
                    public void onGranted(List<String> permissions, boolean all) {
                        if (all) {//获取到
                            LogUtils.e("  Permissions ", "onGranted -->  有权限");
                            saveImageToGallery(getContext(), getViewBitmap(iv_head));
//                                mListener.onCallLook();
                            toast("保存成功");
//                                dismiss();
                        }
                    }
                });
    }

    @Nullable
    private Bitmap getViewBitmap(View view) {
        view.clearFocus();
        view.setPressed(false);
        boolean willNotCache = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int color = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        if (color != 0) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap cacheBitmap = view.getDrawingCache();
        if (cacheBitmap == null) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(willNotCache);
        view.setDrawingCacheBackgroundColor(color);
        return bitmap;
    }

    public static void saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "ysh");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
//            String fileName = System.currentTimeMillis() + ".jpg";
        String fileName = "chuangke" + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + fileName)));
    }

    /**
     * 复制内容到剪切板
     *
     * @param copyStr
     * @return
     */
    private boolean copyStr(String copyStr) {
        try {
            //获取剪贴板管理器
            ClipboardManager cm = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", copyStr);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            toast("复制成功");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}