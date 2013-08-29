package com.zxuqian.bookstore.dao;

import com.zxuqian.bookstore.entities.User;

public interface UserDao {

	User getUserByUserName(String username);
	
}
