package com.zxuqian.bookstore.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.zxuqian.bookstore.dao.BookDao;
import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Comment;

public class BookDaoImpl implements BookDao {

	@Inject
	private Session session;
	
	public void saveOrUpdate(Book book) {
		session.saveOrUpdate(book);
	}

	public List<Book> getAllBooks() {
		return this.session.createQuery("from Book").list();
	}

	public List<Book> getBooksByPage(int page, int max) {
		return this.session.createQuery("from Book").setFirstResult(page)
				.setMaxResults(max).list();
	}

	public Book getBookById(Long id) {
		return (Book)this.session.get(Book.class, id);
	}

	public void deleteBook(Book book) {
		this.session.delete(book);
	}

	public List<Book> getCarouselBooks() {
		return this.session.createQuery("from Book b where b.featured = true")
				.list();
	}

	public void saveOrUpdateComment(Comment comment) {
		this.session.saveOrUpdate(comment);
	}

	public void deleteComment(Comment comment) {
		this.session.delete(comment);
	}

	public List<Comment> getLatestComments() {
		return this.session.
				createQuery("from Comment order by commentDate desc")
				.list();
	}

}
