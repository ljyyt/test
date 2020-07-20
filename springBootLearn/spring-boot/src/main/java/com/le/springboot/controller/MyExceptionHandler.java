package com.le.springboot.controller;

import com.le.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyExceptionHandler
 * @Description TODO
 * @Author lijunyi
 * @Date 2020/2/12 0:45
 * @Version 1.0
 */
//springMVC中要成为异常处理器的注解
@ControllerAdvice
public class MyExceptionHandler {
    //要处理的异常
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("massage","用户出错了！");
        //传入我们自己定义的错误码，400，4xx,500
            request.setAttribute("javax.servlet.error.status_code",400);
        request.setAttribute("ext",map);
        //转发到error，自适应不同客户端
        return "forward:/error";
    }
}
