package com.amber.controller;

import com.amber.bean.Order;
import com.amber.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("")
    public Order initOrder() {
        Order order = orderService.createOrder();
        return order;
    }
}
