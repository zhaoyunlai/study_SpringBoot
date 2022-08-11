package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//扫描servlet
@ServletComponentScan(basePackages = "com.atguigu.boot.servlet")
@SpringBootApplication
public class Boot04WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot04WebAdminApplication.class, args);
    }

}
