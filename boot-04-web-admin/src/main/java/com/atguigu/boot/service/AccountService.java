package com.atguigu.boot.service;

import com.atguigu.boot.bean.Account;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/15:33
 * @Description:
 */
public interface AccountService {
    Account getAccountById(Long id);

    void addAccount(Account account);
}
