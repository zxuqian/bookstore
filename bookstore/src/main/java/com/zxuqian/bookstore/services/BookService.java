package com.zxuqian.bookstore.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.BookDao;
import com.zxuqian.bookstore.dao.InventoryDao;
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
	
	/**
	 * 获取每种书的总价
	 * @return
	 */
	public double getBookTotal(Book book) {
		return book.getPrice() * book.getQuantity();
	}
	
	/**
	 * 小计
	 * @return
	 */
	public double getSubTotal(List<Book> cart) {
		double sum = 0.0d;
		for(Book book : cart) {
			sum += (book.getQuantity() * book.getPrice());
		}
		
		return sum;
	}
	
	/**
	 * 总计
	 * @return
	 */
	public double getGrandTotal(List<Book> cart) {
		return this.getSubTotal(cart);
	}
	
	/**
	 * 更新库存信息
	 * @param cart
	 */
	public void updateInventory(List<Book> cart) {
		for(Book book : cart) {
			int sold = book.getQuantity();
			book = this.bookDao.getBookById(book.getId());
			book.getInventory().setSold(sold);
		}
	}
	
//	/**
//	 * 重新从数据库中关联购物车中的书籍
//	 * @param cart
//	 * @return
//	 */
//	public List<Book> getSessionManagedBooks(List<Book> cart) {
//		List<Book> books = new ArrayList<Book>();
//		for(Book book : cart) {
//			book = this.bookDao.getBookById(book.getId());
//			books.add(book);
//		}
//		
//		return books;
//	}
}
