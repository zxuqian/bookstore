package com.zxuqian.bookstore.services;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.BookDao;
import com.zxuqian.bookstore.entities.Book;

public class BookService {
	
	@Inject
	private BookDao bookDao;

	public void addBook(Book book) {
		bookDao.addBook(book);
	}
	
}
