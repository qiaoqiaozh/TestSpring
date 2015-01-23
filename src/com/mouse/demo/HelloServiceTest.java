package com.mouse.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mouse on 15/1/23.
 */
public class HelloServiceTest {
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("helloworld.xml");
        HelloService hs = context.getBean("helloService",HelloService.class);
        hs.sayHello();
    }
}
