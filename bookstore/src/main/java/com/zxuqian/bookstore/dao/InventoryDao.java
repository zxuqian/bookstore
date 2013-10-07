package com.zxuqian.bookstore.dao;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.Inventory;

public interface InventoryDao {
	
	@CommitAfter
	public void addInventory(Inventory inventory);

}
