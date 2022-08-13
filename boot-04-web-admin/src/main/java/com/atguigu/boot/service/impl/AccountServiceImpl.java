package com.atguigu.boot.service.impl;

import com.atguigu.boot.bean.Account;
import com.atguigu.boot.mapper.AccountMapper;
import com.atguigu.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/15:32
 * @Description:
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccountById(Long id) {
        return accountMapper.getAccount(id);
    }

    @Override
    public void addAccount(Account account) {
        accountMapper.insertAccount(account);
    }
}
