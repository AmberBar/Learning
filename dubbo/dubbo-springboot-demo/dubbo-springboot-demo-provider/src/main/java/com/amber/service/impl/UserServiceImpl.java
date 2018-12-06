package com.amber.service.impl;

import com.amber.bean.Address;
import com.amber.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供者
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.2")
public class UserServiceImpl implements UserService {

    @Override
    public List<Address> findAllAddressByUserId(Integer userId)  {
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(new Address(1,"上海1.0.2", 1));
        addresses.add(new Address(2,"北京1.0.2", 1));
        System.out.println("=========================");
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return addresses;
    }
}
