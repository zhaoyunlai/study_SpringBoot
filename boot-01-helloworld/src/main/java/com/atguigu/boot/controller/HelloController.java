package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/04/14:48
 * @Description:
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello SpringBoot2";
    }
}
