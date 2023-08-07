package com.hzbk.aichat.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.entity.UserDealBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.other.AppConfig;
import com.hzbk.aichat.util.GsonUtil;

public class WebViewActivity extends AppActivity {
    private WebView forum_context;
    private LModule module = new LModule();

    public static void start(Context context, String Param) {
        if (TextUtils.isEmpty(Param)) {
            return;
        }
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(AppConfig.Param, Param);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void initView() {
        forum_context = findViewById(R.id.WebView);
        initWebView();
    }

    private void initWebView() {
        forum_context.getSettings().setJavaScriptEnabled(true);
        forum_context.getSettings().setUseWideViewPort(false);
        forum_context.getSettings().setLoadWithOverviewMode(false);
        // 帮助WebView处理各种通知、请求事件
        forum_context.setWebViewClient(new WebViewClient() {
            /**
             * 是否在 WebView 内加载页面
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            /**
             * WebView 访问 url 出错
             */
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            /**
             * 错误响应的处理
             */
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request,
                                            WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

            /**
             * 重新调整图片资源大小
             * @param view
             * @param url
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                imgReset();
            }
        });
    }

    /**
     * 读取图片资源JS
     */
    private void imgReset() {
        forum_context.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i <objs.length;i++){"
                + "var img = objs[i]; " +
                " img.style.maxWidth = '100%'; img.style.height = 'auto'; " +
                "}" +
                "})()");
    }

    @Override
    protected void initData() {



    }
}