package com.dengzhy.common.utils;

import java.util.UUID;

/**
 *
 * @Author dengzhy
 * @Date 2018/7/30 17:36
 * @param
 * @Return
 */
public class UUIDUtils {
    /**
     * 生成32位UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
