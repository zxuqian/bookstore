package com.zxuqian.bookstore.pages;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;

import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.services.BookService;
import com.zxuqian.bookstore.util.SiteConstants;


/**
 * Start page of application bookstore.
 */
public class Index{
	
	@Inject
	private BookService bookService;
	
	@Property
	private Book book;
	
	public List<Book> getCarouselBooks() {
		return this.bookService.getCarouselBooks();
	}
	
	public String getUploadFolder() {
		return SiteConstants.UPLOAD_FOLDER;
	}

}
