package com.amber.service;

import com.amber.pojo.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findUserByUsername(String username) throws UsernameNotFoundException;
}
