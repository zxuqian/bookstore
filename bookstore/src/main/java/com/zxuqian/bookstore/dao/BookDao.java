package com.zxuqian.bookstore.dao;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.Book;

public interface BookDao {

	@CommitAfter
	public void addBook(Book book);
	
	@CommitAfter
	public List<Book> getAllBooks();
	
	@CommitAfter
	public List<Book> getBooksByPage(int page, int max);
	
}
