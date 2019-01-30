package com.amber.mapper;

import java.util.List;

import com.amber.po.Orders;

public interface OrdersMapper {
	
	List<Orders> findAllOrders();
	
	List<Orders> selectOrders();
}
