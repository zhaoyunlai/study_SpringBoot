package com.atguigu.boot.controller;

import com.atguigu.boot.bean.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/10/14:59
 * @Description:
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private StringRedisTemplate redisTemplate;


    //到登录页
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(LoginUser user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUsername()) && ("123456".equals(user.getPassword()))){
            //将登录成功的用户信息存到session中
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;重定向防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    //去main页面，请求名是main.html
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
//        //是否登录，可以使用拦截器和过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "main";
//        }
//        model.addAttribute("msg","当前未登录");
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String s1 = operations.get("/main.html");
        String s2 = operations.get("/sql");
        String s3 = operations.get("/dynamic_table");
        model.addAttribute("mainCount",s1);
        model.addAttribute("sqlCount",s2);
        model.addAttribute("dynamic_tableCount",s3);
        return "main";
    }
}
