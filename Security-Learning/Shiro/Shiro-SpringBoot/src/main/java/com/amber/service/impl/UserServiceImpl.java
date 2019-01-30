package com.amber.service.impl;

import com.amber.data.po.User;
import com.amber.repository.UserRepository;
import com.amber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByUsername(String name) {
        User user = userRepository.findOneByName(name);
        return user;
    }
}
