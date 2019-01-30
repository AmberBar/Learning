package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserDaoMapper;
import com.mybatis.po.User;

public class UserTest {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() {
		InputStream is = UserTest.class.getClassLoader().getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void test() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserDaoMapper mapper = openSession.getMapper(UserDaoMapper.class);
		List<User> users = mapper.selectAllUsers();
		for (User user: users) {
			System.out.println(user);
		}
	}
}
