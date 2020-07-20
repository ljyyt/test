package com.le.springboot.controller;

import com.le.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijunyi
 * @date 2019/12/8 22:40
 */

@Controller
public class Hello {


    @RequestMapping("/hello")
    public String hi(){
        return "helloWord!";
    }

    //查出数据在页面显示
    @RequestMapping("/thymeleaf")
    public String success(Map<String,Object> map){
        map.put("hello","你好哦！");
        map.put("text","<h1>text转义</h1>");
        map.put("utext","<h1>utext不转义</h1>");
        map.put("myList", Arrays.asList("遍历1", "遍历2"));
        return "success";
    }

    /**
     * 自定义异常测试
     */
    @ResponseBody
    @RequestMapping("/errorTest")
    public String error(@RequestParam("user") String user){
        if(user.equals("error")){
            throw new UserNotExistException();
        }
        return "这是自定义异常测试！";
    }
}
