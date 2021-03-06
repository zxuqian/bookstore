package com.zxuqian.bookstore.pages.user;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import com.zxuqian.bookstore.entities.User;
import com.zxuqian.bookstore.services.UserService;

public class MyAccount {
	
	@Inject
	private UserService userService;
	
	@Property
	@SessionState
	private User user;
	
	private Long id;
	
	public void onActivate(Long id) {
		System.out.println(id + " ++++++++++++++++++++++=");
		this.id = id;
		this.user = this.userService.getUserById(id);
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long onPassivate() {
		return this.id;
	}
	
}
