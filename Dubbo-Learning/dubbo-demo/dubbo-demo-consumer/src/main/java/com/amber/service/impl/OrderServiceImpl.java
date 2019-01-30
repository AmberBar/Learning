package com.amber.service.impl;

import com.amber.bean.Address;
import com.amber.bean.Order;
import com.amber.service.OrderService;
import com.amber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserService userService;

    @Override
    public Order createOrder() {
        Order order = new Order();
        List<Address> addresses = userService.findAllAddressByUserId(1);
        order.setAddress(addresses.get(0));
        System.out.println(order.getAddress());
        return order;
    }
}
