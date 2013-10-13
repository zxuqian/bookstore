package com.zxuqian.bookstore.dao;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.User;

public interface UserDao {
	
	/**
	 * 通过用户名查询用户
	 * @param username 用户名
	 * @return 用户对象
	 */
	@CommitAfter
	User getUserByUserName(String username);
	
	/**
	 * 保存用户信息
	 * @param user 用户对象
	 */
	@CommitAfter
	void saveOrUpdate(User user);
	
	/**
	 * 根据ID获取用户对象
	 * @param id 用户ID
	 * @return 用户对象
	 */
	@CommitAfter
	User getUserById(Long id);
	
}
