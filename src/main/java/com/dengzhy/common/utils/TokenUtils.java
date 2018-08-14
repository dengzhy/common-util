package com.dengzhy.common.utils;

import java.util.UUID;

/**
 *
 * @Author dengzhy
 * @Date 2018/8/14 14:18
 */
public class TokenUtils {

    public static String getToken(){
        String uuid =  UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
