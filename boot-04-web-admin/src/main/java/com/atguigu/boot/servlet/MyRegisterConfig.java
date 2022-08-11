package com.atguigu.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/11/16:12
 * @Description:
 *
 * 1、MyServlet --> /my
 * 2、DispatcherServlet --> /
 */
//(proxyBeanMethods = true):保证是单实例的
@Configuration
public class MyRegisterConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter(){
        MyFilter myFilter = new MyFilter();
        //可以直接从servlet指定拦截，拦截这个servlet处理的所有请求
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter, myServlet());

        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>(myFilter);
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*","/aa/"));
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/aa/"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }

}
