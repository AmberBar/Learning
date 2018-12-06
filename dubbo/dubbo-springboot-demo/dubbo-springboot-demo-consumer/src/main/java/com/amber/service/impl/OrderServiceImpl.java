package com.amber.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.amber.bean.Address;
import com.amber.bean.Order;
import com.amber.service.OrderService;
import com.amber.service.UserService;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(version = "1.0.2", timeout = 2000, retries = 3, stub = "com.amber.service.stub.UserServiceStub")
    private UserService userService;

    @Override
    public Order createOrder() {
        Order order = new Order();
        List<Address> addresses = userService.findAllAddressByUserId(1);
        if (addresses != null) {
            addresses.forEach(address -> System.out.println(address));
            order.setAddress(addresses.get(0));
        }
        order.setCode("10082008820");
        order.setId(1);
        return order;
    }
}
