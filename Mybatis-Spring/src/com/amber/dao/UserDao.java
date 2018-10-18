package com.amber.dao;

import com.amber.po.User;

public interface UserDao {
	
	User findUserById(Integer id);
}
