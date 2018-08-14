package com.dianji.common.result;

/**
 * @author Clark
 * @create 2018/4/27
 * Copyright (C) 杭州典击科技有限公司
 * @description
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
