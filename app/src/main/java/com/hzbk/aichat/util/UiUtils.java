package com.hzbk.aichat.util;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/9/23.
 */
public class UiUtils {


    /**
     * pd 转 px
     *
     * @param context 上下文
     * @param dip     输入dp
     * @return 返回px
     */
    public static int dip2px(Context context, float dip) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * px 转 dp
     *
     * @param context 上下文
     * @param px      输入像素
     * @return 返回dp
     */

    public static int px2dip(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }


    public static int dip2px(float dipValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, Resources.getSystem().getDisplayMetrics());
    }

    public static int sp2px(float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, Resources.getSystem().getDisplayMetrics());
    }

    /**
     * 获取状态栏高度
     *
     * @param context 上下文
     * @return 你懂的 单位 px
     */
    public static int getStatusBarHeight(Context context) {
        try {
            @SuppressLint("PrivateApi") Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * sp转为px
     */
    public static int sp2px(Context context, int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }


    /**
     * 返回屏幕的宽度
     */
    public static int getScreenWidth(Context context) {
        int width = 0;
        if (context instanceof Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            width = displayMetrics.widthPixels;
        } else {
            WindowManager wm = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics outMetrics = new DisplayMetrics();
            if (wm != null) {
                wm.getDefaultDisplay().getMetrics(outMetrics);
                width = outMetrics.widthPixels;
            }

        }
        return width;
    }

    /**
     * 返回屏幕的高度
     *
     * @param context 上下文
     * @return height
     */
    public static int getScreenHeight(Context context) {

        int height = 0;
        if (context instanceof Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            height = displayMetrics.heightPixels;
        } else {
            WindowManager wm = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics outMetrics = new DisplayMetrics();
            if (wm != null) {
                wm.getDefaultDisplay().getMetrics(outMetrics);
                height = outMetrics.heightPixels;
            }

        }
        return height;
    }


    /**
     * 返回屏幕可用高度
     * 当显示了虚拟按键时，会自动减去虚拟按键高度
     */
    public static int getAvailableScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /**
     * 状态栏高度
     */
    public static int getStatusBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 获取虚拟按键的高度
     * 会根据当前是否有显示虚拟按键来返回相应的值
     * 即如果隐藏了虚拟按键，则返回零
     */
    public static int getVirtualBarHeightIfRoom(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int usableHeight = displayMetrics.heightPixels;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        int realHeight = displayMetrics.heightPixels;
        return realHeight - usableHeight;
    }

    /**
     * 获取虚拟按键的高度，不论虚拟按键是否显示都会返回其固定高度
     */
    public static int getVirtualBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 标题栏高度，如果隐藏了标题栏则返回零
     */
    public static int getTitleHeight(Activity activity) {
        return activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
    }

    /**
     * 将dp值转换为px值
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为dp值
     */
    public static int px2dp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 透明度
     *
     * @param originalColor color, without alpha
     * @param alpha         from 0.0 to 1.0
     * @return
     */
    public static String addAlpha(String originalColor, double alpha) {
        long alphaFixed = Math.round(alpha * 255);
        String alphaHex = Long.toHexString(alphaFixed);
        if (alphaHex.length() == 1) {
            alphaHex = "0" + alphaHex;
        }
        originalColor = originalColor.replace("#", "#" + alphaHex);


        return originalColor;
    }
    /*
     * 带文字提示的进度条
     * */
//    public static Dialog getPd(Context context, String msg) {
//        if (context == null) {
//            context = MyApplication.getInstance();
//        }
//        Dialog progressDialog = new Dialog(context, R.style.base_progress_dialog_theme);
//        progressDialog.setContentView(R.layout.base_progress_dialog);
//        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        TextView tv = progressDialog.findViewById(R.id.tv_msg);
//        tv.setText(msg);
//        return progressDialog;
//    }

//    /**
//     * 设置字符串中数字颜色
//     **/
//    public static SpannableStringBuilder setNumColor(String str,Context context) {
//        SpannableStringBuilder style = new SpannableStringBuilder(str);
//        for (int i = 0; i < str.length(); i++) {
//            char a = str.charAt(i);
//            if (a >= '0' && a <= '9') {
//                style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_F94646)), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
//        return style;
//    }
//
//    /**
//     * 设置字符串中数字颜色
//     **/
//    public static SpannableStringBuilder setNumColor2(String str,Context context) {
//        SpannableStringBuilder style = new SpannableStringBuilder(str);
//        for (int i = 0; i < str.length(); i++) {
//            char a = str.charAt(i);
//            if (a >= '0' && a <= '9') {
//                style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_FF8000)), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
//        return style;
//    }


    /**
     * 判断字符串中是否包含数字
     **/
    public static boolean isContainsNum(String input) {
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是否为纯数字和字母
     **/
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /*
     * 是否为浮点数？double或float类型。
     * @param str 传入的字符串。
     * @return 是浮点数返回true,否则返回false。
     */
    public static boolean isDoubleOrFloat(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串是否为纯数字
     **/
    public static boolean isNumericzidai(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    /**
     * 控制输入格式，保留两位小数
     *
     * @param edt Editable
     */
    public static void decimal(Editable edt) {
        if (edt == null) {
            return;
        }

        // 以小数点开头，前面自动加上 "0"
        if (edt.toString().startsWith(".")) {
            edt.insert(0, "0");
        }

        //只能输入一个小数点
        if (edt.toString().contains(".") && edt.toString().lastIndexOf(".") != edt.toString().indexOf(".")) {
            edt.delete(edt.toString().length() - 1, edt.toString().length());
        }

        //保留两位小数
        int posDot = edt.toString().indexOf(".");
        if (posDot <= 0) {
            return;
        }
        if (edt.toString().length() - posDot - 1 > 2) {
            edt.delete(posDot + 3, posDot + 4);
        }
    }
}
