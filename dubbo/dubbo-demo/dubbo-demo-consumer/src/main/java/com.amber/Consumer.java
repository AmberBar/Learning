package com.amber;

import com.amber.bean.Address;
import com.amber.bean.Order;
import com.amber.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        ac.start();
        // Obtaining a remote service proxy
        OrderService orderService = (OrderService)ac.getBean(OrderService.class);
        Order order = orderService.createOrder();
        System.out.println(order);
        System.in.read();
    }
}