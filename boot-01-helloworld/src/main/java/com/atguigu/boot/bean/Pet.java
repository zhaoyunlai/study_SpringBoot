package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/04/16:29
 * @Description:
 */
@Data
@ToString
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
public class Pet {
    private String name;
}
