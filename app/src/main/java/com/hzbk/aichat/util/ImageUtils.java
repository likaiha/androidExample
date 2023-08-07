package com.hzbk.aichat.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hzbk.aichat.R;
import com.hzbk.aichat.http.UrlConfig;
import com.hzbk.aichat.widget.GlideRoundTransform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ImageUtils {


    /**
     * @param context   context
     * @param imageView 图片View
     * @param url       路径
     * @param dp        圆角大小
     */
    public static void RoundImage(Context context, ImageView imageView, String url, int dp) {
//        设置图片圆角角度
//        RequestOptions options = new RequestOptions().error(R.mipmap.iv_placeholder).bitmapTransform(new RoundedCorners(dp));

        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.mipmap.loading)                //加载成功之前占位图
                .error(R.mipmap.iv_placeholder);                 //加载错误之后的错误图
        if (url != null) {
            if (url.startsWith("http")) {
                Glide.with(context)
                        .load(url.trim())
                        .transform(new GlideRoundTransform(context, dp))
                        .apply(requestOptions)
                        .into(imageView);
            } else {
                LogUtils.i("ImageUtils--->" + UrlConfig.baseUrl + url);
                Glide.with(context)
                        .load((UrlConfig.baseUrl + url).trim())
                        .transform(new GlideRoundTransform(context, dp))
                        .apply(requestOptions)
                        .into(imageView);
            }
        }

    }

    /**
     * @param context   context
     * @param imageView 图片View
     * @param url       路径
     * @param dp        圆角大小
     */
    public static void RoundImages(Context context, ImageView imageView, String url, int dp) {
//        设置图片圆角角度
//        RequestOptions options = new RequestOptions().error(R.mipmap.iv_placeholder).bitmapTransform(new RoundedCorners(dp));

        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.mipmap.loading)                //加载成功之前占位图
//                .bitmapTransform(new RoundedCorners(20))
                .error(R.mipmap.iv_placeholder);                 //加载错误之后的错误图
        if (url != null) {
            if (url.startsWith("http")) {
                Glide.with(context)
                        .load(url.trim())
                        .transform(new GlideRoundTransform(context, dp))
                        .apply(requestOptions)
                        .into(imageView);
            } else {
                LogUtils.i("ImageUtils--->" + UrlConfig.baseUrl + url);
                Glide.with(context)
                        .load((UrlConfig.baseUrl + url).trim())
                        .transform(new GlideRoundTransform(context, dp))
                        .apply(requestOptions)
//                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                        .into(imageView);
            }
        }

    }

    /**
     * @param context   context
     * @param imageView 图片View
     * @param url       路径
     */
    public static void showImage(Context context, ImageView imageView, String url) {
        //设置图片圆角角度
        RequestOptions requestOptions = new RequestOptions();
//                .placeholder(R.mipmap.loading)                //加载成功之前占位图
//                .error(R.mipmap.iv_placeholder);                 //加载错误之后的错误图
        if (url != null) {
            if (url.startsWith("http")) {
                Glide.with(context).load(url.trim()).apply(requestOptions).into(imageView);
            } else {
//            LoggerUtils.i("ImageUtils--->" + UrlConfig.baseUrl + url);
                Glide.with(context).load((UrlConfig.baseUrl + url).trim()).apply(requestOptions).into(imageView);
            }
        }

    }

    /**
     * @param context   context
     * @param imageView 图片View
     * @param url       路径
     */
    public static void showImage2(Context context, ImageView imageView, String url) {
        //设置图片圆角角度
//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.mipmap.login_logo)                //加载成功之前占位图
//                .error(R.mipmap.login_logo);                 //加载错误之后的错误图
//        if (url != null) {
//            if (url.startsWith("http")) {
//                Glide.with(context).load(url.trim()).apply(requestOptions).into(imageView);
//            } else {
////            LoggerUtils.i("ImageUtils--->" + UrlConfig.baseUrl + url);
//                Glide.with(context).load((UrlConfig.baseUrl + url).trim()).apply(requestOptions).into(imageView);
//            }
//        }

    }


    //    在这里抽取了一个方法   可以封装到自己的工具类中...
    public static File getFile(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        File file = new File(Environment.getExternalStorageDirectory() + "/temp.jpg");
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            int x = 0;
            byte[] b = new byte[1024 * 100];
            while ((x = is.read(b)) != -1) {
                fos.write(b, 0, x);
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

}
