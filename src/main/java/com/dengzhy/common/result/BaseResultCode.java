package com.dengzhy.common.result;

/**
 *
 * @Author dengzhy
 * @Date 2018/8/14 14:01
 * @Return 
 */
public interface BaseResultCode {
    /**
     * 获取错误码
     */
    public int getCode();

    /**
     * 获取错误消息
     */
    public String getMessage();
}
