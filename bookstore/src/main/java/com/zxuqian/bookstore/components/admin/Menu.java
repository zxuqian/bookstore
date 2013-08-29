package com.zxuqian.bookstore.components.admin;

import javax.inject.Inject;

import org.apache.tapestry5.ComponentResources;

public class Menu {
	
	@Inject
	private ComponentResources resources;
	
	public String getBook() {
		
		if(resources.getPageName().equalsIgnoreCase("admin/book/Index")) {
			return "active";
		}
		return null;
	}
	
	

}
