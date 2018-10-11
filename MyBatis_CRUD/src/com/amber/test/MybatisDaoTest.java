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

import com.amber.po.User;

public class MybatisDaoTest {
	SqlSessionFactory sqlSessionFactory;
	private User user;
	
	@Before
	public void Before() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory =  new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void findUserById()  {
		SqlSession openSession = sqlSessionFactory.openSession();
		User user = openSession.selectOne("test.findUserById", 1);
		System.out.println(user);
	}
	
	@Test
	public void findUserQuzyByusername() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String username = "小明";
		List<User> users = sqlSession.selectList("test.findUserQuzyByusername", username);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void insertUser() {
		User user = new User();
		user.setAddress("shanghai");
		user.setUsername("amber");
		user.setSex("女");
		user.setBirthday(new Date());
		SqlSession openSession = sqlSessionFactory.openSession();
		int num = openSession.insert("test.insertUser", user);
		openSession.commit();
		openSession.close();
		if (num > 0 ) {
			System.out.println("创建成功");
			System.out.println(user);
		} else {
			System.out.println("创建失败");
		}
	}
	
	@Test
	public void updateUser() {
		user = new User();
		user.setId(29);
		user.setAddress("shanghai");
		user.setUsername("amber123");
		user.setSex("女");
		user.setBirthday(new Date());
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int num = sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(num);
	}
	
	@Test
	public void deleteUser() {
		SqlSession sqlSession  = sqlSessionFactory.openSession();
		int num = sqlSession.delete("test.deleteUserById", 60);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(num);
	}
}
