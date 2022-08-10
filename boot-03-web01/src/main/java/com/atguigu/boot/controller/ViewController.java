package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/10/14:41
 * @Description:
 */
@Controller
public class ViewController {

    @GetMapping("/atguigu")
    public String atguigu(Model model){

        model.addAttribute("msg","你好，atguigu");
        model.addAttribute("link","www.bilibili.com");
        return "success";
    }
}
