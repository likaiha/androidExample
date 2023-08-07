package com.hzbk.aichat.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeUtil {


    /**
     * 获取明天的日期字符串
     *
     * @return
     */
    public static String tomorrowDateStr() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 0);
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }


    /**
     * 获取明天的日期字符串
     *
     * @return
     */
    public static String tomorrowDateStr1() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, 1);

        //这个时间就是日期往后推一天的结果
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }


    /**
     * 获取后天的日期字符串
     *
     * @return
     */
    public static String tomorrowDateStr2() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加2天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, 2);

        //这个时间就是日期往后推2天的结果
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }

    /**
     * 获取明天的日期字符串
     *
     * @return
     */
    public static String tomorrowDateStr12() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, 1);

        //这个时间就是日期往后推一天的结果
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }

    /**
     * 获取明天的日期字符串
     *
     * @return
     */
    public static String tomorrowDateStr11() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 0);
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }

    /**
     * 获取后天的日期字符串
     *
     * @return
     */
    public static String tomorrowDateStr13() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加2天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, 2);

        //这个时间就是日期往后推2天的结果
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }

    /**
     * 获取当天的日期字
     *
     * @return
     */
    public static String getDateStr() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 0);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }

    /**
     * 获取明天的日期字符串
     *
     * @return
     */
    public static String getDateStr1() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, 1);

        //这个时间就是日期往后推一天的结果
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }

    /**
     * 获取后天的日期字符串
     *
     * @return
     */
    public static String getDateStr2() {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加2天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, 2);

        //这个时间就是日期往后推2天的结果
        date = calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }

    /**
     * 获取周几
     *
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static String getWeekOfDate1() {
        String week = "";
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
//        LoggerUtils.e(" 时间 ", "明天是周 "+weekday);
        if (weekday == 1) {
            week = "周一";
        } else if (weekday == 2) {
            week = "周二";
        } else if (weekday == 3) {
            week = "周三";
        } else if (weekday == 4) {
            week = "周四";
        } else if (weekday == 5) {
            week = "周五";
        } else if (weekday == 6) {
            week = "周六";
        } else if (weekday == 7) {
            week = "周日";
        }
        return week;
    }


    /**
     * 获取一个月前的日期
     *
     * @return
     */
    public static String getMonthAgo() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        String monthAgo = simpleDateFormat.format(calendar.getTime());
        return monthAgo;
    }

    /**
     * 获取本年第一个月
     *
     * @return
     */
    public static String getOneMonth() {
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        return year + "-01";
    }

    /**
     * 获取 本月 的日期
     *
     * @return
     */
    public static String getToday() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    /**
     * 获取 本月 的日期
     *
     * @return
     */
    public static String getMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }


    public static String getDate(Date date) {//可根据需要自行截取数据显示
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        return format.format(date);
    }

    public static String getDates(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    public static String getDate(String date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        Date date1 = null;
        try {
            date1 = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format.format(date1);
    }

    public static String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
//    public static String getTime(Date date) {//可根据需要自行截取数据显示
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return format.format(date);
//    }

    public static String getTime1(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    public static Date getIDate(int i, Date today) {//i天后是几号
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + i);
        return calendar.getTime();
    }

    /**
     * @param seconds 时间戳秒
     * @return
     */
    public static String timeToStr(String seconds) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date1 = new Date(Long.valueOf(seconds)*1000);
        return simpleDateFormat.format(date1);
    }

    /**
     * @param time 时间
     * @return
     */
    public static String strToStr(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = simpleDateFormat.parse(time);
        return simpleDateFormat.format(date);
    }

    /**
     * 时间字符串转换为时间戳
     *
     * @param s
     * @return
     * @throws ParseException
     */

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime() / 1000;
        String res = String.valueOf(ts);
        return res;
    }

    //时间戳转换成时间解决1970年的问题
    public static String getDateToString(long milSecond) {
        Date date = new Date(milSecond * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date());
    }

    //获取当前时间 yyyy-MM
    public static String getCurrentTimes() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(new Date());
    }
}
