package com.zxuqian.bookstore.pages.admin.system;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;

import com.zxuqian.bookstore.entities.Menu;
import com.zxuqian.bookstore.services.MenuService;

public class IndexSystem {
	
	@Property
	private Menu menu;
	
	private int index = 0;
	
	@Property
	@Inject
	private MenuService menuService;
	
	/**
	 * 获取所有的父菜单
	 * @return
	 */
	public List<Menu> getMenus() {
		return this.menuService.getParentMenus();
	}

	public int getIndex() {
		return ++index;
	}

}
