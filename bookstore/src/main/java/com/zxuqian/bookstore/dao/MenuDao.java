package com.zxuqian.bookstore.dao;

import java.util.List;

import com.zxuqian.bookstore.entities.Menu;

public interface MenuDao {
	
	void addMenu(Menu menu);
	
	List<Menu> getParentMenus();

}
