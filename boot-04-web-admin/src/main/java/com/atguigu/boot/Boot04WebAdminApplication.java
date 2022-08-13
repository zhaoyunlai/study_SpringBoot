package com.atguigu.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

//扫描servlet
@ServletComponentScan(basePackages = "com.atguigu.boot.servlet")
//批量扫描mapper
//@MapperScan(basePackages = "com.atguigu.boot.mapper")
@SpringBootApplication
public class Boot04WebAdminApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Boot04WebAdminApplication.class, args);
        Environment environment = run.getBean(Environment.class);
        //查看一下加密的密匙，测试用
        System.out.println(environment.getProperty("jasypt.encryptor.password"));

        //在程序启动时，jasypt会解密ENC()中的内容
        String mysqlPassword = environment.getProperty("spring.datasource.password");
        String mysqlUsername = environment.getProperty("spring.datasource.username");
        System.out.println("测试数据加密，解密之后的mysql账号密码为：");
        System.out.println("mysqlPassword:"+mysqlPassword+"\nmysqlUsername:"+mysqlUsername);
    }

}
