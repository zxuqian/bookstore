package com.zxuqian.bookstore.pages;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.services.SelectModelFactory;

import com.zxuqian.bookstore.entities.Address;
import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Province;
import com.zxuqian.bookstore.services.AddressService;
import com.zxuqian.bookstore.services.BookService;
import com.zxuqian.bookstore.util.SiteConstants;

public class ShowCart {
	
	@Property
	private Province province;
	
	@Property
	private List<Province> provinces;
	
	@Inject
	private AddressService addressService;
	
	@Inject
	private SelectModelFactory selectModelFactory;
	
	@Inject
	private BookService bookService;
	
	@Property
	@SessionState
	private List<Book> cart;
	
	@Property
	private Book book;
	
	@SessionState
	private Zone cartZone;
	
	@Property
	private final ValueEncoder<Book> encoder = new ValueEncoder<Book>() {

		public String toClient(Book book) {
			return String.valueOf(book.getId());
		}

		public Book toValue(String bookId) {
			Long id = Long.parseLong(bookId);
			System.out.println("what the id is: " + id + "============================");
			for(Book book : cart) {
				if(book.getId().equals(id)) {
					return book;
				}
			}
			return null;
		}
		
	};
	
	public void onActivate() {
		this.provinces = addressService.getProvinces();
	}
		
	
	/**
	 * 获取省份的select model
	 * @return
	 */
	public SelectModel getProvincesModel() {
		return this.selectModelFactory.create(this.provinces, "province");
	}
	
	
	/**
	 * 获取每种书的总价
	 * @return
	 */
	public double getBookTotal() {
		return this.bookService.getBookTotal(this.book);
	}
	
	/**
	 * 获取上传目录
	 * @return
	 */
	public String getUploadFolder() {
		return SiteConstants.UPLOAD_FOLDER;
	}
	
	/**
	 * 删除购物车项
	 * @param book
	 */
	public void onDeleteCartItem(Book book) {
		this.cart.remove(book);
	}

	/**
	 * 小计
	 * @return
	 */
	public double getSubTotal() {
		return this.bookService.getSubTotal(this.cart);
	}
	
	/**
	 * 总计
	 * @return
	 */
	public double getGrandTotal() {
		return this.bookService.getGrandTotal(this.cart);
	}
	
}
