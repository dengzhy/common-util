package com.dianji.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName: IPUtils
 * @Description:
 * @Author zhujunjie
 * @Date 2018 05 12:12
 * Copyright (C) 杭州典击科技有限公司
 */
public class IPUtils {

    /**
     * 获取本机IP地址
     *
     * @Author zhujunjie
     * @Date 18/5/8 12:14
     * @param
     * @Return java.lang.String
     */
    public static String getLocalHost() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return addr.getHostAddress();
    }
}
