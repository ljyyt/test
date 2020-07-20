package com.le.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunyi
 * @date 2019/12/15 10:33
 */

@RestController
public class ConfigTest {

    @RequestMapping("/pathTest")
    public String ret(){
        return "bootConf";
    }
}
