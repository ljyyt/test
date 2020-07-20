package com.le.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author lijunyi
 * @Date 2020/2/3 23:46
 * @Version 1.0
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String passWord,
                        Map<String,Object> map,
                        HttpSession session){
        System.out.println("username:"+userName+"  password:"+passWord);
        //map用于封装错误消息
        if("le".equals(userName)&&"123".equals(passWord)){
            session.setAttribute("loginUser",userName);
            //模拟登录成功,重定向，防止重复提交
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","登录失败！");
            return "login";
        }
    }
}
