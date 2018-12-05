package com.amber.service.impl;

import com.amber.bean.Address;
import com.amber.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {

    @Override
    public List<Address> findAllAddressByUserId(Integer userId) {
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(new Address(1,"上海", 1));
        addresses.add(new Address(2,"北京", 1));
        return addresses;
    }
}
