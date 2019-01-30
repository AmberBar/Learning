package com.amber.service.impl;

import com.amber.Repository.UserRepository;
import com.amber.pojo.User;
import com.amber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not exist");
        }
        return user;
    }
}
