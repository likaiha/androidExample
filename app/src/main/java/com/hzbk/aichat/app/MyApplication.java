package com.hzbk.aichat.app;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.hjq.toast.ToastUtils;
import com.hzbk.aichat.http.UrlConfig;
import com.hzbk.aichat.manager.ActivityManager;
import com.kongzue.baseokhttp.listener.ParameterInterceptListener;
import com.kongzue.baseokhttp.listener.ResponseInterceptListener;
import com.kongzue.baseokhttp.util.BaseOkHttp;
import com.kongzue.baseokhttp.util.JsonMap;
import com.kongzue.baseokhttp.util.Parameter;

public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        initSdk(this);
        myApplication = this;
        ActivityManager.getInstance().init(myApplication);
        MultiDex.install(this);
        initHttp();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private void initHttp() {
        BaseOkHttp.DEBUGMODE = true;
        BaseOkHttp.disallowSameRequest = false;
        BaseOkHttp.serviceUrl = UrlConfig.baseUrl;
        BaseOkHttp.overallHeader = new Parameter()
                .add("XX-Api-Version", "1.1.0")
                .add("XX-Device-Type", "web");
//                .add("DeviceId", Utils.getAndroidId())
//                .add("X-Cross-Token", MD5Utils.encrypt(Utils.getAndroidId() + "IqO01Dias"));
        BaseOkHttp.parameterInterceptListener = new ParameterInterceptListener<JsonMap>() {
            @Override
            public JsonMap onIntercept(Context context, String url, JsonMap o) {
                return null;
            }
        };
        BaseOkHttp.responseInterceptListener = new ResponseInterceptListener() {
            @Override
            public boolean onResponse(Context context, String url, String response, Exception error) {
                if (error != null) {
                    return true;
                } else {
                    //Log.i("!!!", "onResponse: " + response);
                    return true;
                }
            }
        };
        JsonMap.preParsing = true;

    }

    private void initSdk(MyApplication application) {
        ToastUtils.init(application);
        // 初始化 TitleBar 默认样式
//        TitleBar.setDefaultStyle(application);

    }

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }

}
