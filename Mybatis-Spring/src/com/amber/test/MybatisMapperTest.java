package com.amber.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amber.mapper.UserMapper;
import com.amber.po.Orders;
import com.amber.po.User;
import com.amber.vo.QueryVo;

public class MybatisMapperTest {
	ApplicationContext applicationContext;
	@Before
	public void Before() throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void findUserById()  {
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	

}
