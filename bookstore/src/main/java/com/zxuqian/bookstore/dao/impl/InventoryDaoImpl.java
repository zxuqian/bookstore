package com.zxuqian.bookstore.dao.impl;

import javax.inject.Inject;

import org.hibernate.Session;

import com.zxuqian.bookstore.dao.InventoryDao;
import com.zxuqian.bookstore.entities.Inventory;

public class InventoryDaoImpl implements InventoryDao{

	@Inject
	private Session session;
	
	public void addInventory(Inventory inventory) {
		this.session.save(inventory);
	}
	
	

}
