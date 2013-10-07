package com.zxuqian.bookstore.dao;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.Book;

public interface BookDao {

	@CommitAfter
	public void addBook(Book book);
	
}
