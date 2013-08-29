package com.zxuqian.bookstore.services;

import java.util.List;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.MenuDao;
import com.zxuqian.bookstore.entities.Menu;

public class MenuService {
	
	@Inject
	private MenuDao menuDao;
	
	public void addMenu(Menu menu) {
		this.menuDao.addMenu(menu);
	}
	
	public List<Menu> getParentMenus() {
		return this.menuDao.getParentMenus();
	}

}
