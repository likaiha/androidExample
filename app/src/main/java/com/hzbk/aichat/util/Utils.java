package com.hzbk.aichat.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.Collections;
import java.util.List;

public class Utils {
    /**
     * 获取自己应用内部的版本号
     */
    public static int getVersionCode(Context context) {
        PackageManager manager = context.getPackageManager();
        int code = 0;
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            code = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

    public static String getVersionName(Context context) {
        PackageManager manager = context.getPackageManager();
        String name = null;
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            name = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return name;
    }

    public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
        if (a.size() != b.size())
            return false;
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i)))
                return false;
        }
        return true;
    }

    /**
     * 首先进行入参检查防止出现空指针异常
     * 如果两个参数都为空，则返回true
     * 如果有一项为空，则返回false
     * 接着对第一个list进行遍历，如果某一项第二个list里面没有，则返回false
     * 还要再将两个list反过来比较，因为可能一个list是两一个list的子集
     * 如果成功遍历结束，返回true
     *
     * @param list1
     * @param list2
     * @return
     */
    public static boolean isListEqual(List list1, List list2) {
        if (list1.size() == list2.size()) {
            int m = 0;
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).equals(list2.get(i))) {
                    m += 1;
                }
            }
            if (m == list1.size()) {
                return true;
            }

        }
        return false;


    }

}
