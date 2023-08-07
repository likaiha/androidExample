package com.hzbk.aichat.util;

import android.util.Log;

import com.hzbk.aichat.other.AppConfig;

/**
 * log打印管理类
 *
 */

public class LogUtils {

    //是否输出
    private static boolean isDebug = true;

    /**
     * 设置debug模式(true:打印日志  false：不打印)
     */
    public static void isEnableDebug(boolean isDebug){
     LogUtils.isDebug = AppConfig.isDebug();
    }
    /**
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg){
        if(isDebug){
            Log.i(tag, msg != null ? msg : "");
        }
    }

    public static void i(Object object, String msg){
        if(isDebug){
            Log.i(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void i(String msg){
        if(isDebug){
            Log.i(" [INFO] --- ", msg != null ? msg : "");
        }
    }

    /**
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg){
        if(isDebug){
            Log.d(tag, msg != null ? msg : "");
        }
    }

    public static void d(Object object, String msg){
        if(isDebug){
            Log.d(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void d(String msg){
        if(isDebug){
            Log.d(" [DEBUG] --- ", msg != null ? msg : "");
        }
    }

    /**
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg){
        if(isDebug){
            Log.w(tag, msg != null ? msg : "");
        }
    }

    public static void w(Object object, String msg){
        if(isDebug){
            Log.w(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void w(String msg){
        if(isDebug){
            Log.w(" [WARN] --- ", msg != null ? msg : "");
        }
    }

    /**
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg){
        if(isDebug){

            int max_str_length = 2001 - tag.length();
            //大于4000时
            while (msg.length() > max_str_length) {
                Log.e(tag, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            //剩余部分
            Log.e(tag, msg);
        }
    }

    public static void e(Object object, String msg){
        if(isDebug){
            Log.e(object.getClass().getSimpleName(), msg !=null ? msg : "");
        }
    }

    public static void e(String msg){
        if(isDebug){
            Log.e(" [ERROR] --- ", msg !=null ? msg : "");
        }
    }

    /**
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg){
        if(isDebug){
            Log.v(tag, msg != null ? msg : "");
        }
    }

    public static void v(Object object, String msg){
        if(isDebug){
            Log.v(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void v( String msg){
        if(isDebug){
            Log.v(" [VERBOSE] --- ", msg != null ? msg : "");
        }
    }

    /**
     * 超出部分截断输出
     * @param tag
     * @param content
     */
    public static void logE(String tag, String content) {
        int p = 2048;
        long length = content.length();
        if (length < p || length == p){
            Log.e(tag, content);
        } else {
            while (content.length() > p) {
                String logContent = content.substring(0, p);
                content = content.replace(logContent, "");
                Log.e(tag, logContent);
            }
            Log.e("OOOOO", content);
        }
    }

}
