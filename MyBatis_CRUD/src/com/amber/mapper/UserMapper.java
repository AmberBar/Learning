package com.amber.mapper;

import java.util.List;

import com.amber.po.User;

public interface UserMapper {

	User findUserById(Integer id);
	
	List<User> findUserQuzyByusername(String name);
}
