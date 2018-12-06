package com.amber.service.stub;

import com.amber.bean.Address;
import com.amber.service.UserService;

import java.util.List;

public class UserServiceStub implements UserService {
    private final UserService userService;
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }
    @Override
    public List<Address> findAllAddressByUserId(Integer userId) {
        System.out.println("UserServiceStub");
        if (userId == 1) {
            userService.findAllAddressByUserId(userId);
        }
        return null;
    }
}
