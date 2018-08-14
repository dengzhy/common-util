package com.dengzhy.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: GetIpAndBrowserUtil
 * @Description:
 * @Author dengzhy
 * @Date 2018/08/02 11:13
 * @Copyright (C) 杭州典击科技有限公司
 */
public class GetIpAndBrowserUtil {
    /**
     * 获取ip
     * @Author dengzhy
     * @Date 2018/8/2 11:13
     * @param request
     * @Return java.lang.String
     */
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 判断请求来源是手机还是pc
     * @Author dengzhy
     * @Date 2018/8/2 12:06
     * @param request
     * @Return java.lang.String
     */
    public static String getBrowser(HttpServletRequest request) {
        String broswer = null;
        String header = request.getHeader("user-Agent");
        header = header.toLowerCase();
        if (header.contains("chrome")) {
            broswer = "谷歌浏览器";
        } else if (header.contains("msie")) {
            broswer = "IE浏览器";
        } else if (header.contains("firefox")) {
            broswer = "火狐浏览器";
        } else {
            broswer = "未知浏览器";
        }
        return broswer;
    }

}
