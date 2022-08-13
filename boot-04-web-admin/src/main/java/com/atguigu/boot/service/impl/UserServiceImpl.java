package com.atguigu.boot.service.impl;

import com.atguigu.boot.bean.User;
import com.atguigu.boot.mapper.UserMapper;
import com.atguigu.boot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/17:47
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Override
//    public User getUserById(Long id) {
//        return userMapper.selectById(id);
//    }
}
