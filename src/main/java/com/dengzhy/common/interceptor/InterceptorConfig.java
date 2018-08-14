package com.dengzhy.common.interceptor;

import com.dengzhy.common.permission.PermissionSignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: InterceptorConfig
 * @Description:
 * @Author dengzhy
 * @Date 2018/08/01 9:21
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getPermissionInterceptor(){
        return new PermissionSignInterceptor();
    }
    /**
     * 使用拦截器
     * @Author dengzhy
     * @Date 2018/8/1 9:23
     * @param registry
     * @Return void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getPermissionInterceptor()).addPathPatterns("/platForm/**");
        //拦截以/platForm/下的所有请求
    }
}
