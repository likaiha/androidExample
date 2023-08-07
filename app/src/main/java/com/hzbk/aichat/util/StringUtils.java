package com.hzbk.aichat.util;

import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {

    public static final String REGEX_IP = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
    public static String mobileEncrypt(String mobile) {
        final String PHONE_BLUR_REGEX = "(\\d{3})\\d{4}(\\d{4})";
        /** * 手机号脱敏替换正则 */
        final String PHONE_BLUR_REPLACE_REGEX = "$1****$2";
        /** * 手机号格式校验 * @param phone * @return */
        if (mobile.isEmpty() || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll(PHONE_BLUR_REGEX, PHONE_BLUR_REPLACE_REGEX);
    }

    /**
     * 验证IP地址
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isIP(final CharSequence input) {
        return isMatch(REGEX_IP, input);
    }

    /**
     * 判断是否匹配正则
     *
     * @param regex 正则表达式
     * @param input 要匹配的字符串
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMatch(final String regex, final CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

    public static String listToString1(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return list.isEmpty() ? "" : sb.toString().substring(0, sb.toString().length() - 1);
    }
}
