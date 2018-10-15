package com.amber.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import com.amber.mapper.OrdersMapper;
import com.amber.mapper.UserMapper;
import com.amber.po.Orders;

public class MybatisMapperOrdersTest {
	
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void Before() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory =  new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void selectOrders() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper =  sqlSession.getMapper(OrdersMapper.class);
		List<Orders> orders =  ordersMapper.selectOrders();
		for (Orders orders2 : orders) {
			System.out.println(orders2);
		}
	}
	
	@Test
	public void findAllOrders()  {
		SqlSession  openSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = openSession.getMapper(OrdersMapper.class);
		List<Orders> ordersList = mapper.findAllOrders();
		for (Orders order : ordersList) {
			System.out.println(order);
		}
	}
}
