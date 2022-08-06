package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/05/16:12
 * @Description:
 *
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
//@Component
//prefix前缀
@ConfigurationProperties(prefix = "mycar")
@Data
@ToString
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
public class Car {
    private String brand;
    private Integer price;
}
