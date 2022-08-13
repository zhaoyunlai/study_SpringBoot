package com.atguigu.boot.config;

import com.atguigu.boot.interceptor.LoginInterceptor;
import com.atguigu.boot.interceptor.RedisURLCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

    /**
     *Filter、Interceptor 几乎拥有相同的功能
     * 1、Filter是Servlet定义的原生组件。好处就是可以脱离Spring使用
     * 2、Interceptor是Spring定义的接口。
     */
    @Autowired
    private RedisURLCountInterceptor redisURLCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//静态资源也会拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sql","/account","/dynamic_table/**");//放行的请求

        registry.addInterceptor(redisURLCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }

    /**
     * 定义静态资源行为
     * 访问 /aa/** 所有请求都去classpath:/static/ 下面进行匹配
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }
}
