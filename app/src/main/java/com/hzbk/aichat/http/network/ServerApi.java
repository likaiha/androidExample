package com.hzbk.aichat.http.network;




import com.hzbk.aichat.entity.CaptchaCheckIt;
import com.hzbk.aichat.entity.CaptchaGetIt;
import com.hzbk.aichat.entity.WordCaptchaGetIt;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Date:2020/5/18
 * author:wuyan
 */
public interface ServerApi {

    final static String BaseUrl = "https://captcha.anji-plus.com/captcha-api/";
//    final static String BaseUrl = "http://10.108.12.11:8080/";

    //获取验证码
    @POST("captcha/get")
    Observable<BaseResponse<CaptchaGetIt>> getAsync(@Body RequestBody body);

    //获取文字的验证码
    @POST("captcha/get")
    Observable<BaseResponse<WordCaptchaGetIt>> getWordCaptchaAsync(@Body RequestBody body);

    //核对验证码
    @POST("captcha/check")
    Observable<BaseResponse<CaptchaCheckIt>> checkAsync(@Body RequestBody body);
}
