package com.selestudy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName :HelloworldController
 * Package :com.selestudy.springboot.controller
 * Description :
 *
 * @author :张哈哈
 * @date :2020/10/16 14:21
 */
@Controller
public class HelloworldController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello  world";
    }
}
