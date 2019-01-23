package com.amber.controller;

import com.amber.modal.User;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "Users API", description = "Users API")
public class UserController {

    @GetMapping("")
    @ApiOperation(value = "get all users", notes = "")
    public ResponseEntity<List<User>> getUsers(){
        ArrayList<User> users = Lists.newArrayList(new User("amber", "abc", 1),
                new User("amber", "abc", 2));
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
