package com.dianji.common.utils;

import java.util.UUID;

/**
 * @author:xiaochuang
 * @description:
 * @date: 15:04 2018/5/21
 * @modified by
 */
public class TokenUtils {

    public static String getToken(){
        String uuid =  UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
