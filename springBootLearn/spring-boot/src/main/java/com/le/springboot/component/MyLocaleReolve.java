package com.le.springboot.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName MyLocaleReolve
 * @Description 区域信息解析器
 * @Author lijunyi
 * @Date 2020/1/14
 * @Version 1.0
 */

/**
 * 获取url中的区域信息
 */
public class MyLocaleReolve implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lan=httpServletRequest.getParameter("lan");
        Locale locale=Locale.getDefault();//系统默认区域信息
        System.out.println("lan:"+lan);
        if(!StringUtils.isEmpty(lan)){
            String [] split=lan.split("_");
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
