package com.dengzhy.common.permission;


import com.dengzhy.common.enums.ApiExceptionEnum;
import com.dengzhy.common.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @Author dengzhy
 * @Date 2018/7/30 11:14
 * @Return
 */
public class PermissionSignInterceptor extends HandlerInterceptorAdapter {

    public static final Logger logger = LoggerFactory.getLogger(PermissionSignInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法中获取
        PermissionAnnotation permissionAnnotation = handlerMethod.getMethodAnnotation(PermissionAnnotation.class);

        //不需要验证登录
        if (permissionAnnotation != null && !permissionAnnotation.isLogin()) {
            return true;
        }
        //获取当前登录用户
        Object userLoginResult = request.getSession().getAttribute("UserLoginResult");
        if (userLoginResult == null) {
            //当前没有登录
            throw new ApiException(ApiExceptionEnum.USER_NOT_LOGIN);
        }
        return true;
    }


}
