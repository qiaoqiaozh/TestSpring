package com.ioc.test;

import com.mouse.demo.HelloService;

/**
 * Created by mouse on 15/1/23.
 */
public class Test {
    public static void main(String[] args) throws Exception
    {
        MyIoC mi = new MyIoC("src/helloworld.xml");

        HelloService hs = (HelloService)mi.getBean("helloService");

        hs.sayHello();
    }
}
