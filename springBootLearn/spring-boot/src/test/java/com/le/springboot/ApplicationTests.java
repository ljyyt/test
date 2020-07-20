package com.le.springboot;

import com.le.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());


    public static void main(String [] args){

    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void helloSer(){
        System.out.println(ioc.containsBean("helloService"));
    }

    @Test
    public void logTest(){

        //日志级别由低到高  trace<debug<info<warn<error
        logger.trace("trace日志...");
        logger.debug("debug日志...");
        //springboot默认使用info级别，没有指定使用默认级别：root级别
        logger.info("info日志...");
        logger.warn("warn日志...");
        logger.error("error日志...");
    }
}
