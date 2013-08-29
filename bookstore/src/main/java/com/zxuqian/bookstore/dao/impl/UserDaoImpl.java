package com.zxuqian.bookstore.dao.impl;

import javax.inject.Inject;

import org.hibernate.Session;

import com.zxuqian.bookstore.dao.UserDao;
import com.zxuqian.bookstore.entities.User;

public class UserDaoImpl implements UserDao {
	
	@Inject
	private Session session;

	public User getUserByUserName(String username) {
		return (User)session.createQuery("from User u where u.username=:username")
				.setString("username", username).uniqueResult();
	}

}
