package com.amber.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.amber.mapper.UserMapper;
import com.amber.po.User;

public class MybatisMapperTest {
	SqlSessionFactory sqlSessionFactory;
	private User user;
	
	@Before
	public void Before() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory =  new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void findUserById()  {
		SqlSession  openSession = sqlSessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void findUserQuzyByusername() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String username = "小明";
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.findUserQuzyByusername(username);
		for (User user : users) {
			System.out.println(user);
		}
	}
}
