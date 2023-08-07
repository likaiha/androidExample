package com.hzbk.aichat.http;

import static com.luck.picture.lib.thread.PictureThreadUtils.runOnUiThread;

import android.app.Application;
import android.content.Intent;
import android.util.ArrayMap;

import com.hzbk.aichat.app.MyApplication;
import com.hzbk.aichat.manager.ActivityManager;
import com.hzbk.aichat.other.SpBean;
import com.hzbk.aichat.ui.activity.LoginActivity;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.SPUtils;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import com.kongzue.baseokhttp.util.Parameter;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;


public class LModule extends BaseModule {
    private static final String TAG = "LModule";

    /**
     * 登录
     */
    public void login(String username, String password, MCallback callback) {
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("username", username);
        parameters.put("password", password);
        HttpRequest.JSONPOST(MyApplication.getInstance(), UrlConfig.login, new Parameter()
//                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.type) )
                , new JSONObject(parameters).toString(), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }

    /**
     * 登录
     */
    public void codeLogin(String username, String password, MCallback callback) {
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("username", username);
        parameters.put("verification_code", password);
        HttpRequest.JSONPOST(MyApplication.getInstance(), UrlConfig.codeLogin, new Parameter()
//                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.type) )
                , new JSONObject(parameters).toString(), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }

    /**
     * 重置
     */
    public void passwordReset(String username, String password, String verification_code, MCallback callback) {
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("username", username);
        parameters.put("password", password);
        parameters.put("verification_code", verification_code);
        HttpRequest.JSONPOST(MyApplication.getInstance(), UrlConfig.passwordReset, new Parameter()
//                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.type) )
                , new JSONObject(parameters).toString(), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }

    /**
     * 短信接口
     *
     * @param phone
     * @param callback
     */
    public void getSendCode(String phone, MCallback callback) {
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("username", phone);
        LogUtils.e("参数 json  ", String.valueOf(new JSONObject(parameters)));
        HttpRequest.JSONPOST(MyApplication.getInstance(), UrlConfig.sendCode, new Parameter()
//                        .add("Authorization", SPUtils.getInstance().getString(SpBean.type) + " " + SPUtils.getInstance().getString(SpBean.token))
                , new JSONObject(parameters).toString(), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }


    public void getRegister(String phone, String vscode, String password
            , String code, MCallback callback) {
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("username", phone);
        parameters.put("verification_code", code);
        parameters.put("password", password);
        parameters.put("share_code", vscode);


        HttpRequest.JSONPOST(MyApplication.getInstance(), UrlConfig.register, new Parameter()
//                        .add("Authorization", SPUtils.getInstance().getString(SpBean.type) + " " + SPUtils.getInstance().getString(SpBean.token))
                , new JSONObject(parameters).toString(), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }

    public void homepageAd(MCallback callback) {
        HttpRequest.GET(MyApplication.getInstance(), UrlConfig.homepageAd, new Parameter()
                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.Token))
                , new Parameter(), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );

    }

    public void getCategoryPostLists(String category_id, MCallback callback) {

        HttpRequest.GET(MyApplication.getInstance(), UrlConfig.getCategoryPostLists, new Parameter()
                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.Token))
                , new Parameter().add("category_id", category_id), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );

    }

    public void indexProduct(String type, MCallback callback) {
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("type", type);
        HttpRequest.GET(MyApplication.getInstance(), UrlConfig.indexProduct, new Parameter()
                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.Token))
                , new Parameter().add("type", type), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }

    public void userInfo(MCallback callback) {
        HttpRequest.GET(MyApplication.getInstance(), UrlConfig.userInfo, new Parameter()
                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.Token))
                , new Parameter(), new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }


    public void checkApp(String version, MCallback callback) {
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("version", version);
        HttpRequest.JSONPOST(MyApplication.getInstance(), UrlConfig.checkApp, new Parameter()
                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.Token)),
                new JSONObject(parameters).toString(),
                new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }

    public void passwordChange(String oldPas, String password, String confirm, MCallback callback){
        Map<String, Object> parameters = new ArrayMap<>();
        parameters.put("original_password", oldPas);
        parameters.put("password", password);
        parameters.put("confirm_password",confirm);


        HttpRequest.JSONPOST(MyApplication.getInstance(), UrlConfig.passwordChange, new Parameter()
                        .add("XX-Token", SPUtils.getInstance().getString(SpBean.Token)),
                new JSONObject(parameters).toString(),
                new ResponseListener() {
                    @Override
                    public void onResponse(String main, Exception error) {
                        if (main != null) {
                            getSuccess(main.toString(), callback);
                        } else {
                            getFailed(error, callback);
                        }
                    }
                }
        );
    }





    protected void getSuccess(String response, MCallback callback) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            String status = jsonObject.getString("code");
            if (status.equals("1")) {  //结果成功
                runOnUiThread(new Runnable() {
                    public void run() {
                        callback.onSuccess(response);
                    }
                });
            } else if (status.equals("10001")) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        SPUtils.getInstance().put(SpBean.Login, false);
                        Application application = ActivityManager.getInstance().getApplication();
                        Intent intent = new Intent(application, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        application.startActivity(intent);
//                        // 销毁除了登录页之外的 Activity
                        ActivityManager.getInstance().finishAllActivities(LoginActivity.class);
                    }
                });

            } else {  // 结果失败
                String msg = jsonObject.getString("msg");
                runOnUiThread(new Runnable() {
                    public void run() {
                        callback.onError(msg + "", status);
                    }
                });
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void getFailed(Exception e, MCallback callback) {
        runOnUiThread(new Runnable() {
            public void run() {
                callback.onFailed(e);
            }
        });
    }
}
