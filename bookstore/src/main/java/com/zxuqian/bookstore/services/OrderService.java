package com.zxuqian.bookstore.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.OrderDao;
import com.zxuqian.bookstore.entities.Order;

public class OrderService {
	
	@Inject
	private OrderDao orderDao;
	
	public void saveOrUpdateOrder(Order order) {
		this.orderDao.saveOrUpdateOrder(order);
	}

	public List<Order> getAllOrders() {
		return this.orderDao.getAllOrders();
	}

	public List<Order> getOrdersByUser(Long userId) {
		return this.orderDao.getOrdersByUser(userId);
	}

	public void deleteOrder(Order order) {
		this.orderDao.deleteOrder(order);
	}

	public String getOrderNumber() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderNumber = sdf.format(new Date());
		orderNumber += (int)(Math.random() * 1000);
		
		return orderNumber;
	}

}
