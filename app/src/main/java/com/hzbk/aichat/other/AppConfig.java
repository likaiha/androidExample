package com.hzbk.aichat.other;


import com.hzbk.aichat.BuildConfig;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/09/02
 *    desc   : App 配置管理类
 */
public final class AppConfig {
    public static String RegexMOBILE = "^1\\d{10}$";
    public final static int CHOOSE_IMAGE = 1001;
    public final static String ID = "Id";
    public final static String addressId = "addressId";
    public final static String province = "province";
    public final static String city = "city";
    public final static String district = "district";
    public final static String provinceId = "provinceId";
    public final static String cityId = "cityId";
    public final static String districtId = "districtId";
    public final static String isDefault = "isDefault";
    public final static String phone = "phone";
    public final static String name = "name";
    public final static String address = "address";
    public final static String Param = "param";
    public final static String type = "type";
    public final static String Title = "Title";
    public final static String sku = "sku";
    public final static String num = "num";
    public static final String PHONE = "phone";
    public static final String NAME = "name";
    public static String WECHAT_APPID="";
    public static String WECHAT_SECRET="";

    /**
     * 当前是否为调试模式
     */
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

//    /**
//     * 获取当前构建的模式
//     */
//    public static String getBuildType() {
//        return BuildConfig.BUILD_TYPE;
//    }
//
//    /**
//     * 当前是否要开启日志打印功能
//     */
//    public static boolean isLogEnable() {
//        return BuildConfig.LOG_ENABLE;
//    }
//
//    /**
//     * 获取当前应用的包名
//     */
//    public static String getPackageName() {
//        return BuildConfig.APPLICATION_ID;
//    }
//
//    /**
//     * 获取当前应用的版本名
//     */
//    public static String getVersionName() {
//        return BuildConfig.VERSION_NAME;
//    }
//
//    /**
//     * 获取当前应用的版本码
//     */
//    public static int getVersionCode() {
//        return BuildConfig.VERSION_CODE;
//    }
//
//    /**
//     * 获取 Bugly Id
//     */
//    public static String getBuglyId() {
//        return BuildConfig.BUGLY_ID;
//    }

    /**
     * 获取服务器主机地址
     */
    public static String getHostUrl() {
//        return BuildConfig.HOST_URL;
        return "";
    }
}