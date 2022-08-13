package com.atguigu.boot;

import com.atguigu.boot.bean.User;
import com.atguigu.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot04WebAdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {

        Long num = (Long)jdbcTemplate.queryForObject("select count(*) from t_user_origin",Long.class);
        log.info("数据数为{}",num);

        log.info("数据源类型{}",dataSource.getClass());
        //数据源类型class com.alibaba.druid.pool.DruidDataSource
    }

    @Autowired
    private UserService userService;
    @Test
    public void testUser(){
//        User user = userService.getUserById(1L);
        User user = userService.getById(1L);
        System.out.println(user);
    }



}
