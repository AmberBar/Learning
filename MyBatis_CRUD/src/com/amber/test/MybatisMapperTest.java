package com.amber.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.amber.mapper.UserMapper;
import com.amber.po.User;
import com.amber.vo.QueryVo;

public class MybatisMapperTest {
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void Before() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory =  new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void findUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		Integer[] ids = {10, 48, 25};
		queryVo.setIds(ids);
		List<User> users = mapper.findUserByUserId(queryVo);
		for (User user2 : users) {
			System.out.println(user2);
		}
	}
	
	@Test
	public void findUserByUsernameAndSex() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("小明");
		List<User> users = mapper.findUsersByUsernameAndSex(user);
		for (User user2 : users) {
			System.out.println(user2);
		}
		
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
