package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/06/16:18
 * @Description:
 */
@RestController
public class HelloController {


    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
