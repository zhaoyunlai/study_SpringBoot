package com.atguigu.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//扫描servlet
@ServletComponentScan(basePackages = "com.atguigu.boot.servlet")
//批量扫描mapper
//@MapperScan(basePackages = "com.atguigu.boot.mapper")
@SpringBootApplication
public class Boot04WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot04WebAdminApplication.class, args);
    }

}
