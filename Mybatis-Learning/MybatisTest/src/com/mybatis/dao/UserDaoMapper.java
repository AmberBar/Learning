package com.mybatis.dao;

import java.util.List;

import com.mybatis.po.User;

public interface UserDaoMapper {
	List<User> selectAllUsers();
}
