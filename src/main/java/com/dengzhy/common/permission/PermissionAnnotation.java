package com.dengzhy.common.permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: dengzhy
 * Date: 2017/3/14 14:05
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionAnnotation {
    /**
     * 是否需要登录，默认需要
     */
    boolean isLogin() default true;
}
