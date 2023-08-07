package com.hzbk.aichat.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadUtil {

    private final static String TAG = "MyThread";

    public static final ThreadUtil INST = new ThreadUtil();
    private ExecutorService executors;

    private ThreadUtil() {
    }

    public void excute(Runnable runnable) {
        ExecutorService executorService = this.getExecutorService();
        if (executorService != null) {
            executorService.execute(runnable);
        } else {
            (new Thread(runnable)).start();
        }

    }

    public void excuteInMainThread(Runnable runnable) {
        (new Handler(Looper.getMainLooper())).post(runnable);
    }

    private ExecutorService getExecutorService() {
        if (this.executors == null) {
            try {
                this.executors = Executors.newCachedThreadPool();
            } catch (Exception var2) {
                Log.e(TAG, "create thread service error:" + var2.getMessage());
            }
        }

        return this.executors;
    }
}