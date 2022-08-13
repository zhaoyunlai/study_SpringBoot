package com.atguigu.boot.mapper;

import com.atguigu.boot.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/17:44
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
