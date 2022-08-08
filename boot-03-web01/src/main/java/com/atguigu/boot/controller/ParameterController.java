package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/08/11:35
 * @Description:
 */
@RestController
public class ParameterController {

    //在@PathVariable注释后面使用Map集合可以获取所有的请求参数
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> kv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);

        map.put("kv",kv);

        map.put("User-Agent",userAgent);
        map.put("header",header);
        return map;
    }

    /**
     *  1、语法：  /cars/sell;low=34;brand=byd,audi,yd
     *  这里sell是路径传参，就是说最后一个/后面都是参数
     *  2、SpringBoot默认是禁用了矩阵变量的功能
     *     手动开启：原理：对于路径的处理都是使用UrlPathHelper进行解析，
     *     removeSemicolonContent（移除分号内容）支持矩阵变量
     *
     *  3、矩阵变量一定必须有url路径
     */
    @GetMapping("/cars/{path}")
    public Map<String,Object> carSell(
            @MatrixVariable("low") Integer low,
            @MatrixVariable("brand") List<String> brands,
            @PathVariable("path") String path
            ){

        HashMap<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brands",brands);
        map.put("path",path);
        return map;
    }

    //   /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String,Object> boss(
            @MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
            @MatrixVariable(value = "age",pathVar = "empId") Integer empAge
                                   ){
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }

}
