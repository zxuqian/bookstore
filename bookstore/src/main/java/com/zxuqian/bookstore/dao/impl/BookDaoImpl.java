package com.zxuqian.bookstore.dao.impl;

import javax.inject.Inject;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.zxuqian.bookstore.dao.BookDao;
import com.zxuqian.bookstore.entities.Book;

public class BookDaoImpl implements BookDao {

	@Inject
	private Session session;
	
	public void addBook(Book book) {
		session.save(book);
	}

}
