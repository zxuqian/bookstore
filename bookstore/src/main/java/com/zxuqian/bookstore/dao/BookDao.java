package com.zxuqian.bookstore.dao;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Comment;

public interface BookDao {

	@CommitAfter
	public void saveOrUpdate(Book book);
	
	@CommitAfter
	public List<Book> getAllBooks();
	
	@CommitAfter
	public List<Book> getBooksByPage(int page, int max);
	
	@CommitAfter
	public Book getBookById(Long id);
	
	@CommitAfter
	public void deleteBook(Book book);
	
	@CommitAfter
	public List<Book> getCarouselBooks();
	
	@CommitAfter
	public void saveOrUpdateComment(Comment comment);
	
	@CommitAfter
	public void deleteComment(Comment comment);
	
	@CommitAfter
	public List<Comment> getLatestComments();
	
}
