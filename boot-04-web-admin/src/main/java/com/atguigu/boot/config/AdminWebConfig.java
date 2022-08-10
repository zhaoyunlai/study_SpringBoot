package com.atguigu.boot.config;

import com.atguigu.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/10/17:33
 * @Description:
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors方法）
 * 3、指定拦截规则，注意静态资源的问题
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//静态资源也会拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//放行的请求
    }
}
