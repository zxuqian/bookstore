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
	
	public void saveOrUpdate(User user) {
		this.userDao.saveOrUpdate(user);
	}
	
	public User getUserById(Long id) {
		return this.userDao.getUserById(id);
	}
}
