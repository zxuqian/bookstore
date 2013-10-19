package com.zxuqian.bookstore.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;

import com.zxuqian.bookstore.dao.OrderDao;
import com.zxuqian.bookstore.entities.Order;

public class OrderDaoImpl implements OrderDao {
	
	@Inject
	private Session session;

	public void saveOrUpdateOrder(Order order) {
		this.session.saveOrUpdate(order);
	}

	public List<Order> getAllOrders() {
		return this.session.createQuery("from Order").list();
	}

	public List<Order> getOrdersByUser(Long userId) {
		return this.session.createQuery("from Order where user_id=?").setLong(0, userId).list();
	}

	public void deleteOrder(Order order) {
		this.session.delete(order);
	}

}
