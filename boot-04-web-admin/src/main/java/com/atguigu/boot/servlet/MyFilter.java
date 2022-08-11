package com.atguigu.boot.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/11/16:00
 * @Description:
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
//@WebFilter 不指定URLPatterns，默认为拦截全部
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest res = (HttpServletRequest) request;
        log.info("MyFilter工作，请求为："+res.getRequestURI());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
