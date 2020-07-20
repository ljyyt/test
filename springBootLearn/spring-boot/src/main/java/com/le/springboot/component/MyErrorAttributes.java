package com.le.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @ClassName MyErrorAttributes
 * @Description TODO
 * @Author lijunyi
 * @Date 2020/2/12 1:06
 * @Version 1.0
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map=super.getErrorAttributes(webRequest, includeStackTrace);
        //自己添加的内容
        map.put("company","乐易");
        //自定义异常处理器携带的内容
        Map<String, Object> requestMap=(Map<String, Object>)webRequest.getAttribute("ext",0);
        map.put("ext",requestMap);
        return map;
    }
}
