package com.zxuqian.bookstore.pages;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.services.ComponentSource;

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
	
	@Property
	@SessionState
	private List<Book> cart;
	
	@SessionState
	private Zone cartZone;
	
	public List<Book> getCarouselBooks() {
		return this.bookService.getCarouselBooks();
	}
	
	public String getUploadFolder() {
		return SiteConstants.UPLOAD_FOLDER;
	}
	
	public Object onAddToCart(Book book) {
		book.setQuantity(1);
//		if(this.cart.contains(book)) {
//			this.cart.get(this.cart.indexOf(book)).
//				setQuantity(this.cart.get(this.cart.indexOf(book))
//						.getQuantity() + 1);
//		} else {
			this.cart.add(book);
//		}
		return this.cartZone.getBody();
	}
	
}
