package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/04/16:32
 * @Description:
 *
 * 1、配置类中使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods: 代理bean的方法。
 *
 *   如果是true：Full(proxyBeanMethods = true)
 *   IOC容器是他的代理对象，通过代理对象调用组件注册的方法时，
 *   SpringBoot会首先检查IOC容器中是否存在这个组件，若存在就会返回，
 *   也就是说外部无论如何获取的都是之前注册到容器中的对象。
 *
 *   如果是false：Lite(proxyBeanMethods = false)
 *   不是代理对象，外部调用组件的注册方法时，是直接new的
 *
 *   最佳实践：
 *     ■ 配置 类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
 *     ■ 配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式
 *
 *   4、@Import({User.class, DBHelper.class})
 *   给容器中自动创建出这两类型的组件、默认组件的名字就是全类名
 *
 *   5、
 */


//@Import({User.class, DBHelper.class})

//告诉SpringBoot这是一个配置类 == 配置文件
@Configuration(proxyBeanMethods = false)
//根据xml文件配置bean，用的比较少
//@ImportResource("classpath:beans.xml")
//1、开启Car的属性配置功能，car的属性配置才能生效
//2、将组件自动注册到容器中
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

    //条件装配，只有容器中有tom这个bean时才会创建这个User
    @ConditionalOnBean(name = "tom")
    @Bean("user01") // 给容器中添加组件，以方法名作为组件的id。返回类型就是组件类型。
    //返回的值就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        zhangsan.setPet(new Pet("laifu"));
        return zhangsan;
    }
}
