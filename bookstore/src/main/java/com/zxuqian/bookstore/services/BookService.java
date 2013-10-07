package com.zxuqian.bookstore.services;

import java.util.List;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.BookDao;
import com.zxuqian.bookstore.entities.Book;

public class BookService {
	
	@Inject
	private BookDao bookDao;

	public void addBook(Book book) {
		bookDao.addBook(book);
	}
	
	public List<Book> getAllBooks() {
		return this.bookDao.getAllBooks();
	}

	public List<Book> getBooksByPage(int page, int max) {
		return this.bookDao.getBooksByPage(page, max);
	}
	
}
