package com.zxuqian.bookstore.pages;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.services.SelectModelFactory;

import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Province;
import com.zxuqian.bookstore.util.SiteConstants;

public class ShowCart {
	
	@Property
	private Province province;
	
	@Property
	private List<Province> provinces;
	
	@Inject
	private SelectModelFactory selectModelFactory;
	
	@Property
	@SessionState
	private List<Book> cart;
	
	@Property
	private Book book;
		
	
	/**
	 * 获取省份的select model
	 * @return
	 */
	public SelectModel getProvincesModel() {
		return this.selectModelFactory.create(this.provinces, "province");
	}
	
	/**
	 * 获取没有重复的书籍
	 * @return
	 */
	public List<Book> getUnifiedBooks() {
		List<Book> allBooks = new ArrayList<Book>(this.cart);
		for(Book book : allBooks) {
			while(allBooks.lastIndexOf(book) != allBooks.indexOf(book)) {
				allBooks.get(allBooks.indexOf(book))
					.setQuantity(allBooks.get(allBooks.lastIndexOf(book))
							.getQuantity() 
							+ allBooks.get(allBooks.indexOf(book))
							.getQuantity());
				allBooks.remove(allBooks.lastIndexOf(book));
			}
		}
		return allBooks;
	}
	
	/**
	 * 获取每种书的总价
	 * @return
	 */
	public double getBookTotal() {
		return this.book.getPrice() * this.book.getQuantity();
	}
	
	public String getUploadFolder() {
		return SiteConstants.UPLOAD_FOLDER;
	}

}
