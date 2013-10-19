package com.zxuqian.bookstore.dao;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.Order;

public interface OrderDao {
	
	@CommitAfter
	void saveOrUpdateOrder(Order order);
	
	@CommitAfter
	List<Order> getAllOrders();
	
	@CommitAfter
	List<Order> getOrdersByUser(Long userId);
	
	@CommitAfter
	void deleteOrder(Order order);

}
