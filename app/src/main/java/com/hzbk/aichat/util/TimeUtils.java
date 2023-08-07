package com.hzbk.aichat.util;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    //
//    public static String format(Date date, String pattern) {
//        if (date == null) {
//            return null;
//        }
//        try {
//            return DateFormatUtils.format(date, pattern);
//        } catch (Exception e) {
//            return StringUtils.EMPTY;
//        }
//    }
//
//
//    TimeUtils.format(userTokenDetail.getCreateTime(),"yyyy-MM-dd HH:mm")

    @SuppressLint("SimpleDateFormat")
    public static String format(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat aaa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return aaa.format(date);
    }


}
