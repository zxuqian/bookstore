package com.zxuqian.bookstore.services;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.InventoryDao;
import com.zxuqian.bookstore.entities.Inventory;

public class InventoryService {
	
	@Inject
	private InventoryDao inventoryDao;
	
	public void addInventory(Inventory inventory) {
		this.inventoryDao.addInventory(inventory);
	}

}
