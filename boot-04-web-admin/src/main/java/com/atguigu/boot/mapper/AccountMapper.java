package com.atguigu.boot.mapper;

import com.atguigu.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/15:09
 * @Description:
 */
@Mapper
public interface AccountMapper {

    Account getAccount(Long id);

//    @Select("select * from account_tbl where id = #{id}")
//    Account getAccount1(Long id);

    void insertAccount(Account account);
}
