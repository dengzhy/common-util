package com.dianji.common.utils;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;


public class StringUtil extends StringUtils {

    /**
     * 生成随机验证码【数字】
     */
    public static String getRandomCodeA(Integer count) {
        String code = "";
        char[] codes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            code += codes[r.nextInt(codes.length)];
        }
        return code;
    }

    /**
     * 功能:生成随机码【英文+数字】
     *
     * @param count 随机码的位数
     */
    public static String getRandomCodeB(Integer count) {
        String code = "";
        char[] codes = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            code += codes[r.nextInt(codes.length)];
        }
        return code;
    }


    /**
     * 生成订单编号
     *
     * @return 订单编号
     */
    public static String genOrderNo() {
        Date curDate = new Date();
        String dateStr4yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(curDate);
        String dateStr4SSS = new SimpleDateFormat("SSS").format(curDate);
        String random = RandomStringUtils.random(4, false, true);
        return dateStr4yyyyMMddHHmmss + random + dateStr4SSS;
    }

    /**
     * 功能:根据时间，生成不重复的字符串
     */
    public static String createUniqueStrByDate(Integer count) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        char[] codes = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random r = new Random();
        String code = "";
        for (int i = 0; i < count; i++) {
            code += codes[r.nextInt(codes.length)];
        }
        return sdf.format(date) + code;
    }
    /**
     * 功能:根据时间，生成不重复的字符串(可用作主键等)
     */
    public static String createUniqueStrByDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        char[] A_Z = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Random random = new Random();
        int i = random.nextInt(52);
        return sdf.format(date) + A_Z[i];
    }

    /**
     * 功能:根据时间，生成不重复long类型的字符串
     */
    public static long createUniqueLongByDate() {
        String code = "";
        char[] codes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            code += codes[r.nextInt(codes.length)];
        }
        return Long.valueOf(code + System.currentTimeMillis());
    }

    /**
     * 把重量转换成string
     */
    public static String createKG(Integer kg) {
        if (kg != null && kg > 0) {
            return kg + "KG";
        }
        return "";
    }


    /**
     * 比较字符串
     */
    public static final Comparator<String> StringComparator = (s1, s2) -> {
        int n1 = s1 == null ? 0 : s1.length();
        int n2 = s2 == null ? 0 : s2.length();
        int mn = n1 < n2 ? n1 : n2;
        for (int i = 0; i < mn; i++) {
            int k = s1.charAt(i) - s2.charAt(i);
            if (k != 0) {
                return k;
            }
        }
        return n1 - n2;
    };
}
