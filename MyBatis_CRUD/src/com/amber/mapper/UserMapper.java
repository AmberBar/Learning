package com.amber.mapper;

import java.util.List;

import com.amber.po.User;
import com.amber.vo.QueryVo;

public interface UserMapper {

	User findUserById(Integer id);
	
	List<User> findUserQuzyByusername(String name);
	
	List<User> findUsersByUsernameAndSex(User user);
	
	List<User> findUserByUserId(QueryVo queryVo);
}
