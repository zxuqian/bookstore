package com.zxuqian.bookstore.components.admin;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Property;
import org.slf4j.Logger;

import com.zxuqian.bookstore.services.MenuService;

public class Menu {
	
	@Inject
	private Logger logger;
	
	@Inject
	private ComponentResources resources;
	
	@Inject
	private MenuService menuService;
	
	@Property
	private com.zxuqian.bookstore.entities.Menu menu;
	
	
	/**
	 * 获取所有的菜单
	 * @return 父菜单
	 */
	public List<com.zxuqian.bookstore.entities.Menu> getMenus() {
		return menuService.getParentMenus();
	}
	
	/**
	 * 获取需要激活的菜单
	 * @return
	 */
	public String getActiveMenu() {
		
		logger.debug("entered getActiveMenu method, the page name is: "
		+ resources.getPageName() + " and the url is: " + menu.getUrl());
		
		String[] pageNames = resources.getPageName().split("/");
		String[] menuUrls = menu.getUrl().split("/");
		
		if(pageNames.length > 1 && menuUrls.length > 1) {
			if(pageNames[0].equalsIgnoreCase(menuUrls[0]) && pageNames[1].equalsIgnoreCase(menuUrls[1])) {
				return "active";
			}
		}
		
		return "";
	}
	
	public String getBook() {
		
//		if(resources.getPageName().equalsIgnoreCase("admin/book/Index")) {
//			return "active";
//		}
		return null;
	}
	
	

}
