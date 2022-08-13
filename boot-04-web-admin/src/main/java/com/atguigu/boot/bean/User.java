package com.atguigu.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/17:43
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("use_tbl")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //要求所有属性都应该在表中，
    // 如果不存在，就可以用这个注解属性标注
    @TableField(exist = false)
    private String exclude;

}
