package com.hzbk.aichat.http;

/**
 * Created by
 */
public class UrlConfig {

    public static final String baseUrl = "http://192.168.0.1:9999/api";//线上


    /**
     * 验证码
     */
    public static final String sendCode = "/user/verification_code/send";
    /**
     * 登录
     */
    public static final String login = "/user/public/login";
    /**
     * 验证码登录
     */
    public static final String codeLogin = "/user/public/codeLogin";
    /**
     * 注册
     */
    public static final String register = "/user/public/register";
    /**
     * 首页  banner
     */
    public static final String homepageAd = "/portal/index/banner";
    /**
     * 首页  goodsList
     */
    public static final String indexProduct = "/portal/index/indexProduct";

    /**
     * 获取用户信息
     */
    public static final String userInfo = "/user/my/userInfo";
    /**
     * 忘记密码
     */
    public static final String passwordReset = "/user/public/passwordReset";

    /**
     * 重置密码
     */
    public static final String passwordChange = "/user/public/passwordChange";



    /**
     * 首页  homepageNotice
     */
    public static final String getCategoryPostLists = "/portal/lists/getCategoryPostLists";




    /**
     * 购物车选项
     */
    public static final String selectAllStatus = "/order/cart/selectAllStatus";
    /**
     * 购物车
     */
    public static final String selectStatus = "/order/cart/selectStatus";

    /**
     * 转账
     */
    public static final String transfer = "/user/my/transfer";


    /**
     * 版本更新
     */
    public static final String checkApp = "user/my/checkApp";

}
