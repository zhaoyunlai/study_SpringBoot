package com.atguigu.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/12/9:36
 * @Description:
 */
@Deprecated
//@Configuration
public class MyDataSourceConfig {

    /**
     * 底层的配置中，@ConditionalOnMissingBean(DataSource.class)，
       默认的配置是只要容器中有了我们这里自定义的数据源组件，默认的数据源就不会注册

     参考底层数据源配置类绑定配置文件的属性
    使用  @ConfigurationProperties(prefix = "spring.datasource")，表示数据源的属性和配置文件中绑定
     **/
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        //加入监控功能，防火墙 .注意：这里使用set方法设置的属性，都可以使用配置文件
        dataSource.setFilters("stat,wall");

        return dataSource;
    }

    /**
     * 配置Druid的监控功能
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        //添加访问密码，配置初始化参数
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","druid");
        return registrationBean;
    }

    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据。
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //添加初始化参数，排除哪些请求
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
