package com.le.springboot.conf;

import com.le.springboot.component.LoginHandlerInterceptor;
import com.le.springboot.component.MyLocaleReolve;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName MyMvcConfig
 * @Description WebMvcConfigurerAdapter可以扩展SpringMVC的功能
 * @Author lijunyi
 * @Date 2020/1/12 0:42
 * @Version 1.0
 */

/*Spring 5.0后，WebMvcConfigurerAdapter被废弃，取代的方法有两种：
①implements WebMvcConfigurer（官方推荐）
②extends WebMvcConfigurationSupport
使用第一种方法是实现了一个接口，可以任意实现里面的方法，不会影响到Spring Boot自身的@EnableAutoConfiguration，
而使用第二种方法相当于覆盖了@EnableAutoConfiguration里的所有方法，每个方法都需要重写，比如，若不实现方法addResourceHandlers()，
则会导致静态资源无法访问
*/
//@EnableWebMvc     该注解可以全部接管SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //重定向到后台主页，添加视图映射，让模板解析
        registry.addViewController("/cs").setViewName("success");
    }

    //所有组件都会一起起作用,前端控制器
    @Bean
    public WebMvcConfigurer getWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("mainIndex");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //SpringBoot已经做好了静态资源映射，*.css,*.js
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };

    }

    /**
     * 自定义区域信息解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleReolve();
    }


}
