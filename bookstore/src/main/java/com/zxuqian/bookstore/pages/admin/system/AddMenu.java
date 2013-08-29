package com.zxuqian.bookstore.pages.admin.system;

import javax.inject.Inject;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.services.SelectModelFactory;
import org.slf4j.Logger;

import com.zxuqian.bookstore.entities.Menu;
import com.zxuqian.bookstore.services.MenuService;

public class AddMenu {
	
	@Inject
	private Logger logger;
	
	@Property
	private Menu menu;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private boolean success;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String msg;
	
	@Property
	private Menu parent;
	
	/**
	 * 获取菜单的select model，用于渲染<select>标签
	 */
	@Inject
	private SelectModelFactory selectModelFactory;
	
	@Property
	@Inject
	private MenuService menuService;
	
	public AddMenu() {
		menu = new Menu();
	}
	
	public SelectModel getParentMenus() {
		return this.selectModelFactory.create(this.menuService.getParentMenus(), "menuName");
	}
	
	@CommitAfter
	public void onSubmit() {
		logger.debug("获取到的菜单为： " + menu.getMenuName());
		
		if(this.parent != null) {
			logger.debug("获取到的父菜单为： " + parent.getMenuName() + " -> ID: " + parent.getId());
			this.menu.setParent(parent);
		}
		
		menuService.addMenu(menu);
		
		this.success = true;
		this.msg = "保存成功";
	}
}
