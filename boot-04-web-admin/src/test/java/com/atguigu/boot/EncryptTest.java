package com.atguigu.boot;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/13/20:11
 * @Description:
 */
@SpringBootTest
public class EncryptTest {

    //加密的工具
    @Qualifier("jasyptStringEncryptor")
    @Autowired
    private StringEncryptor stringEncryptor;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void getEncryptedPwd(){
//        Environment environment = applicationContext.getBean(Environment.class);
//        //获取配置文件中的明文密码
//        String mysqlPassword = environment.getProperty("spring.datasource.password");
//        String redisPassword = environment.getProperty("spring.redis.password");
//        System.out.println("明文信息为如下：");
//        System.out.println("mysqlPassword:"+mysqlPassword+"\nredisPassword:"+redisPassword);

        System.out.println("========加密之后的信息如下===============");
        System.out.println("mysqlPassword:"+encrypt("root"));
        System.out.println("redisPassword:"+encrypt("123321"));
        System.out.println("mysqlUsername:"+encrypt("root"));
    }

    public String encrypt(String str){
        return stringEncryptor.encrypt(str);
    }
}
