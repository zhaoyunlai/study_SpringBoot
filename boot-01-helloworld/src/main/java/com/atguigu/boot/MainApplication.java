package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/04/14:45
 * @Description:
 */

/**
 * 主程序类
 * @SpringBootApplication: 这是一个SpringBoot应用
 */
@SpringBootApplication
@ComponentScan("com.atguigu")
public class MainApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看所有组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

//        //3、从容器中获取组件
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//
//        System.out.println("tom组件 tom01 == tom02:"+(tom01 == tom02));
//
//        //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$7aaab365@8dfe921
//        //获取的是代理对象
//        MyConfig myConfig = run.getBean(MyConfig.class);
//        System.out.println(myConfig);
//
//        //如果proxyBeanMethods = true，代理对象调用方法。
//        User user1 = myConfig.user01();
//        User user2 = myConfig.user01();
//        System.out.println("user组件："+(user1 == user2));
//
//        System.out.println("组件依赖："+(user1.getPet() == tom01));
//
//
//        //5、获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("========");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        DBHelper dbHelper = run.getBean(DBHelper.class);
//        System.out.println(dbHelper);

        boolean tom = run.containsBean("tom");
        boolean user01 = run.containsBean("user01");
        System.out.println("组件tom："+tom);
        System.out.println("组件user01："+user01);

//        System.out.println(run.getBean(User.class));
    }
}
