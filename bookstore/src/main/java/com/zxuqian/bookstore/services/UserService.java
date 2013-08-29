package com.zxuqian.bookstore.services;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.UserDao;
import com.zxuqian.bookstore.entities.User;

public class UserService {

	@Inject
	private UserDao userDao;
	
	public User getUserByUsername(String username) {
		return userDao.getUserByUserName(username);
	}
	
}
