package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/04/14:48
 * @Description:
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car(){
        //浏览器中得到：{"brand":"BYD","price":10000}
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){
        log.info("请求进来了......");
        return "Hello SpringBoot2";
    }
}
