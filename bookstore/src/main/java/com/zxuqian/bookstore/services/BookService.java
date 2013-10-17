package com.zxuqian.bookstore.services;

import java.util.List;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.BookDao;
import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Comment;

public class BookService {
	
	@Inject
	private BookDao bookDao;

	public void saveOrUpdate(Book book) {
		bookDao.saveOrUpdate(book);
	}
	
	public List<Book> getAllBooks() {
		return this.bookDao.getAllBooks();
	}

	public List<Book> getBooksByPage(int page, int max) {
		return this.bookDao.getBooksByPage(page, max);
	}
	
	public Book getBookById(Long id) {
		return this.bookDao.getBookById(id);
	}
	
	public void deleteBook(Book book) {
		this.bookDao.deleteBook(book);
	}
	
	public void deleteBook(Long id) {
		this.bookDao.deleteBook(this.bookDao.getBookById(id));
	}
	
	public List<Book> getCarouselBooks() {
		return this.bookDao.getCarouselBooks();
	}
	
	public void saveOrUpdateComment(Comment comment) {
		this.bookDao.saveOrUpdateComment(comment);
	}

	public void deleteComment(Comment comment) {
		this.bookDao.deleteComment(comment);
	}
	
	public List<Comment> getLatestComments() {
		return this.bookDao.getLatestComments();
	}
}
