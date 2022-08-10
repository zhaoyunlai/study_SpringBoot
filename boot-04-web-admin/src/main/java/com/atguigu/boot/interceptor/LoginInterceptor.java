package com.atguigu.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/10/17:31
 * @Description:
 * 登录检查
 * 1、配置好拦截器要拦截哪些请求
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle拦截的请求路径是{}",request.getRequestURI());
        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        //放行
        if(loginUser != null){
            return true;
        }
//        response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);
        session.setAttribute("msg","请先登录");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行{}",ex);
    }
}
