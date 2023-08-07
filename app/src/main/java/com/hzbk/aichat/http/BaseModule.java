package com.hzbk.aichat.http;



public abstract class BaseModule {


    protected abstract void getFailed(Exception e, MCallback callback);

    protected abstract void getSuccess(String response, MCallback callback);
}
