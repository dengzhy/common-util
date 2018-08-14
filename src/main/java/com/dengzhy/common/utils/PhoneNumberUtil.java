package com.dengzhy.common.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {

    private PhoneNumberUtil() {
    }

    private static Pattern pattern = Pattern.compile("^1\\d{10}$");

    /**
     * 手机号6-8位加星号
     *
     * @param mobile 手机号
     * @return 加星后的手机号
     */
    public static String mobileMask(String mobile) {
        if (mobile == null || mobile.trim().length() != 11) {
            return null;
        }
        String prefix = mobile.substring(0, 5);
        String suffix = mobile.substring(mobile.length() - 3, mobile.length());
        return prefix + "***" + suffix;
    }

    /**
     * 验证是否是手机号
     *
     * @param mobile 手机号
     */
    public static Boolean isMobileNumber(String mobile) {
        if (mobile == null) {
            return false;
        }
        Matcher m = pattern.matcher(mobile);
        return m.matches();
    }
}
