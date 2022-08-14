package com.atguigu.boot.config;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/14/9:32
 * @Description:
 * 自定义加密器，可以自己配置加密规则等
 * 怎么说捏，就目前我的水平来看，配置文件完全可以代替这些。
 * 所以就知道我们可以自定义加密器，怎么去定义就可以了
 */
@Configuration
public class EncryptorConfig {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor zylaiEncryptor(@Value("${jasypt.encryptor.password}") String password){

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
//        config.setProviderName("zylai");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
