package com.atguigu.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/10/18:15
 * @Description:
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts.html")
    public String form_layouts(){

        return "form/form_layouts";
    }

    /**
     *
     * MultipartFile 自动封装上传过来的文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("avatar") MultipartFile avatar,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={},username={},avatar={},photos={}",
                email,username,avatar.getSize(),photos.length);
        if(!avatar.isEmpty()){
            //保存到文件服务器或者OSS
            String filename = avatar.getOriginalFilename();
            filename= UUID.randomUUID()+filename;
            avatar.transferTo(new File("D:\\27519\\cache\\"+filename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String filename = photo.getOriginalFilename();
                    filename= UUID.randomUUID()+filename;
                    photo.transferTo(new File("D:\\27519\\cache\\"+filename));
                }
            }
        }

        return "main";
    }
}
