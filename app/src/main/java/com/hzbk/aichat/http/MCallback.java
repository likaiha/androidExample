package com.hzbk.aichat.http;




public interface MCallback {


    /**
     * 结果
     * @param response
     */
    void onSuccess(String response);

    /**
     * msg
     * @param msg
     * @param status
     */
    void onError(String msg, String status);

    /**
     * 错误的
     * @param e
     */
    void onFailed(Exception e);

}
