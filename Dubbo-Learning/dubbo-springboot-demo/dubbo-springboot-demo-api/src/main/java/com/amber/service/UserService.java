package com.amber.service;

import com.amber.bean.Address;

import java.util.List;

public interface UserService {

    List<Address> findAllAddressByUserId(Integer userId);
}
