package com.amber.controller;


import com.amber.Repository.UserRepository;
import com.amber.pojo.User;
import com.amber.service.UserService;
import com.amber.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenUtil jwtUtils;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userVO) {
        User user = userService.findUserByUsername(userVO.getName());
        if (userVO.getPassword() != null) {
            boolean matches = encoder.matches(userVO.getPassword(), user.getPassword());
            if (!matches) {
                throw new UsernameNotFoundException("user not exist!");
            }
        }

        String token = jwtUtils.generateToken(user);
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody User userVO) {
        User user = userService.findUserByUsername(userVO.getName());
        if (userVO.getPassword() != null) {
            boolean matches = encoder.matches(userVO.getPassword(), user.getPassword());
            if (!matches) {
                throw new UsernameNotFoundException("user not exist!");
            }
        }

        String token = jwtUtils.generateToken(user);
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> createUser() {
        List<User> allUsers = userService.findAllUsers();
        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }
}
