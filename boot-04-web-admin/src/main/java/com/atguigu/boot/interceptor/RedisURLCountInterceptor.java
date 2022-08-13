package com.atguigu.boot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/13/15:50
 * @Description:
 */
//这里进行了RedisTemplate的注入，所以这个类要注入到容器才可以
@Component
public class RedisURLCountInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        //默认每次访问当前uri就会计数加一
        redisTemplate.opsForValue().increment(uri);
        return true;
    }

}
