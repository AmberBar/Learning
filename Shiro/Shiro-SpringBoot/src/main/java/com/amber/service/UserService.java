package com.amber.service;

import com.amber.data.po.User;

public interface UserService {

    User findUserByUsername(String name);
}
