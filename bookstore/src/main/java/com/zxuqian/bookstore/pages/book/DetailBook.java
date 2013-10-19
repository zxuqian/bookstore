package com.zxuqian.bookstore.pages.book;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Comment;
import com.zxuqian.bookstore.services.BookService;
import com.zxuqian.bookstore.util.SiteConstants;

public class DetailBook {
	
	@Environmental
	private JavaScriptSupport javascriptSupport;
	
	@Inject
	@Path("context:frontend/book.js")
	private Asset bookScript;
	
	@Inject
	private BookService bookService;
	
	@Property
	private Book book;
	
	@Property
	private Comment comment;
	
	@Property
	@SessionState
	private List<Book> cart;
	private boolean cartExists;
	
	@SessionState
	private Zone cartZone;
	
	@Property
	private int quantity = 1;
	
	public void onActivate(Long id) {
		this.book = this.bookService.getBookById(id);
	}
	
	public void afterRender() {
		this.javascriptSupport.importJavaScriptLibrary(bookScript);
	}
	
	/**
	 * 添加到购物车
	 * @param book
	 * @return
	 */
	public Object onSuccessFromAddToCart(Book book) {
		book.setQuantity(this.quantity);
		if(this.cart.contains(book)) {
			this.cart.get(this.cart.indexOf(book)).
				setQuantity(this.cart.get(this.cart.indexOf(book))
						.getQuantity() + this.quantity);
		} else {
		//if(!cartExists) {
		//	this.cart = new ArrayList<Book>();
		//}
		
			book.setQuantity(quantity);
			this.cart.add(book);
		}
		return this.cartZone.getBody();
	}
	
	/**
	 * 获取上传目录
	 * @return
	 */
	public String getUploadFolder() {
		return SiteConstants.UPLOAD_FOLDER;
	}
	
	/**
	 * 获取图书库存状态
	 * @return
	 */
	public String getBookState() {
		if(this.book.getInventory() != null) {
			if(this.book.getInventory().getRemains() > 0 && this.book.getInventory().getRemains() < 10) {
				return "此图书只剩" + this.book.getInventory().getRemains() + "件";
			}
			return SiteConstants.BOOK_IN_STOCK;
		}
		
		return SiteConstants.BOOK_NOT_AVAILABLE;
	}
	
	/**
	 * 获取图书出版日期
	 * @return
	 */
	public String getPublishDate() {
		return new SimpleDateFormat("yyyy年MM月dd日").format(this.book.getPublishDate());
	}
	
	public void onPrepareFromAddComment() {
		this.comment = new Comment();
	}
	
	/**
	 * 保存书评
	 */
	public void onSuccessFromAddComment() {
		
		this.bookService.saveOrUpdateComment(comment);
		this.book.getComments().add(this.comment);
		this.bookService.saveOrUpdate(this.book);
		
	}
	
	/**
	 * 获取平均星星 此页面暂时不用
	 * @return
	 */
	public double getStars() {
		double sum = 0.0;
		for(Comment comment : this.book.getComments()) {
			sum += comment.getStar();
		}
		
		return sum / (this.book.getComments() != null ? 
				this.book.getComments().size() : 1);
	}
	
	/**
	 * 获取本书的评论数
	 * @return
	 */
	public int getCommentsCount() {
		return this.book.getComments() != null ? 
				this.book.getComments().size() : 0;
	}
	
	public List<Comment> getLatestComments() {
		return this.bookService.getLatestComments();
	}
	
	Object onPassivate() {
		return this.book.getId();
	}
	
}
