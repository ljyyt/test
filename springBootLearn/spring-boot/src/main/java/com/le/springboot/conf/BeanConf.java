package com.le.springboot.conf;

import com.le.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijunyi
 * @date 2019/12/9 1:04
 */

//指明当前类是配置类
@Configuration
public class BeanConf {
    //将方法的返回值添加到容器中，组件名默认是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("添加helloService到容器");
        return new HelloService();
    }

}
