package com.zxuqian.bookstore.pages.admin;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;

import com.zxuqian.bookstore.entities.User;
import com.zxuqian.bookstore.services.UserService;

public class Login {
	
	@Property
	private String username;
	
	@Property
	private String password;
	
	@Inject
	private UserService userService;
	
	public void onSubmit() {
		User user = userService.getUserByUsername(username);
		
		System.out.println(user.getPassword());
	}

}
