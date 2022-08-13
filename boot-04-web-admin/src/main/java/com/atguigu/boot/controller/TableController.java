package com.atguigu.boot.controller;

import com.atguigu.boot.bean.User;
import com.atguigu.boot.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/10/15:46
 * @Description:
 */
@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
//        int a = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,
                                @RequestParam("current") Integer current){
//        List<User> list = userService.list();
        //分页查询数据
        int size = 2;//每页的数据数，可以由前端请求发过来，也可以写死。一般不会写死
        Page<User> userPage = new Page<>(current,size);
        //查询之后，数据会封装在传入的page中
        userService.page(userPage, null);

        model.addAttribute("page",userPage);
        return "table/dynamic_table";
    }

    //为了方便，就直接用get了
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "current",defaultValue = "1") Integer current){

        userService.removeById(id);
        System.out.println(id);

        return "redirect:/dynamic_table?current="+current;
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
