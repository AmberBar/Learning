package com.amber.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.amber.po.User;

public class UserMapperTest {
	
	@Test
	public void test() {
		String resource = "sqlMapConfig.xml";
		InputStream is;
		try {
			is = Resources.getResourceAsStream(resource);
			//创建sqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			SqlSession openSession = sqlSessionFactory.openSession();
			User user = openSession.selectOne("test.findOneById", 10);
			System.out.println(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
