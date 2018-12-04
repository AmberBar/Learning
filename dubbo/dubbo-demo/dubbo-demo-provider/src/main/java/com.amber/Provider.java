package com.amber;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("classpath:provider.xml");
        cx.start();
        System.in.read();
    }
}
