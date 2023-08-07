package com.hzbk.aichat.ui.activity;


import android.content.Context;
import android.os.Handler;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.other.SpBean;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.SPUtils;

public class SplashActivity extends AppActivity {

    private static final int DELAY = 2000;
    private Handler mHandler = new Handler();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                boolean booLean = SPUtils.getInstance().getBoolean(SpBean.IS_FIRST, true);
//                if (!booLean) {
                LogUtils.e(" splash ", "PASSWORDBL--> " + SPUtils.getInstance().getBoolean(SpBean.Login));
                if (SPUtils.getInstance().getBoolean(SpBean.Login)) {
                    startActivity(HomeActivity.class);
                    finish();
//                    startActivity(MainActivity.class);
                } else {
                    startActivity(LoginActivity.class);
                    finish();
                }
//                } else {
//
//                    LogUtils.e("SplashActivity", "SplashActivity  3");
//                    finish();
//                    startActivity(GuideActivity.class);
//                    SPUtils.getInstance().put(SpBean.IS_FIRST, false);
//                }

            }
        }, DELAY);
    }

    @Override
    protected void initData() {

    }


    /**
     * 显示用户协议和隐私政策
     */
    private void showPrivacy(Context context) {
//
//        final PrivacyDialog dialog = new PrivacyDialog(SplashActivity.this);
//        TextView tv_privacy_tips = dialog.findViewById(R.id.tv_privacy_tips);
//        TextView btn_exit = dialog.findViewById(R.id.btn_exit);
//        TextView btn_enter = dialog.findViewById(R.id.btn_enter);
//        dialog.show();
//        String string = context.getResources().getString(R.string.privacy_tips);
//        String key1 = context.getResources().getString(R.string.privacy_tips_key1);
//        String key2 = context.getResources().getString(R.string.privacy_tips_key2);
//        int index1 = string.indexOf(key1);
//        int index2 = string.indexOf(key2);
//        //需要显示的字串
//        SpannableString spannedString = new SpannableString(string);
//        //设置点击字体颜色
//        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(getResources().getColor(R.color.color_7310FF));
//        spannedString.setSpan(colorSpan1, index1, index1 + key1.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        ForegroundColorSpan colorSpan2 = new ForegroundColorSpan(getResources().getColor(R.color.color_7310FF));
//        spannedString.setSpan(colorSpan2, index2, index2 + key2.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        //设置点击字体大小
//        AbsoluteSizeSpan sizeSpan1 = new AbsoluteSizeSpan(16, true);
//        spannedString.setSpan(sizeSpan1, index1, index1 + key1.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        AbsoluteSizeSpan sizeSpan2 = new AbsoluteSizeSpan(16, true);
//        spannedString.setSpan(sizeSpan2, index2, index2 + key2.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        //设置点击事件
//        ClickableSpan clickableSpan1 = new ClickableSpan() {
//            @Override
//            public void onClick(View view) {//用户协议
//                WebViewActivity.start(getActivity(), "https://om.zzqtrj.net/about/UserAgreement.html");//用户协议
//            }
//            @Override
//            public void updateDrawState(TextPaint ds) {
//                //点击事件去掉下划线
//                ds.setUnderlineText(false);
//            }
//        };
//        spannedString.setSpan(clickableSpan1, index1, index1 + key1.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//
//        ClickableSpan clickableSpan2 = new ClickableSpan() {
//            @Override
//            public void onClick(View view) {//隐私政策
//                WebViewActivity.start(getActivity(), "https://om.zzqtrj.net/about/PrivacyProtection.html");//隐私政策
//            }
//
//            @Override
//            public void updateDrawState(TextPaint ds) {
//                //点击事件去掉下划线
//                ds.setUnderlineText(false);
//            }
//        };
//        spannedString.setSpan(clickableSpan2, index2, index2 + key2.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        //设置点击后的颜色为透明，否则会一直出现高亮
//        tv_privacy_tips.setHighlightColor(Color.TRANSPARENT);
//        //开始响应点击事件
//        tv_privacy_tips.setMovementMethod(LinkMovementMethod.getInstance());
//        tv_privacy_tips.setText(spannedString);
//        //设置弹框宽度占屏幕的80%
//        WindowManager m = getWindowManager();
//        Display defaultDisplay = m.getDefaultDisplay();
//        final WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.width = (int) (defaultDisplay.getWidth() * 0.80);
//        dialog.getWindow().setAttributes(params);
//
//        btn_exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                finish();
//            }
//        });
//
//        btn_enter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SPUtils.getInstance().put(SpBean.IS_First, false);
//                boolean aBoolean = SPUtils.getInstance().getBoolean(SpBean.IS_CHECK, true);
//                if (aBoolean) {//第一次请求权限 弹出用户隐私权限
//                    getXXPermissions();
//                    SPUtils.getInstance().put(SpBean.IS_CHECK, false);
//                    dialog.dismiss();
//                }
//            }
//        });
    }


}