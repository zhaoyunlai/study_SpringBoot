package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Account;
import com.atguigu.boot.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/15:30
 * @Description:
 */
@Slf4j
//全部返回json数据
@RestController
public class DbController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public Account getById(@RequestParam("id") Long id){
        return  accountService.getAccountById(id);
    }

    @PostMapping("/account")
    public Account addAccount(Account account){
        accountService.addAccount(account);
        return account;
    }



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    public String queryFromDb(){
        Long num = (Long)jdbcTemplate.queryForObject("select count(*) from t_user_origin",Long.class);
        log.info("数据数为{}",num);
        return num.toString();
    }
}
