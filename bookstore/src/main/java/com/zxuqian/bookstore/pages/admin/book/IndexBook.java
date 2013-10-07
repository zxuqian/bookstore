package com.zxuqian.bookstore.pages.admin.book;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;

import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.services.BookService;

@Import(library = "context:admin/book.js")
public class IndexBook {
	
	/**
	 * 所有图书
	 */
	@Property
	private List<Book> books;
	
	/**
	 * 图书实体
	 */
	@Property
	private Book book;
	
	/**
	 * bookService
	 */
	@Inject
	private BookService bookService;
	
	
	void setupRender() {
		this.books = this.bookService.getAllBooks();
	}
	
	JSONObject getOptions() {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		return null;
		//jsonObject.put("oLanguage", value)
	}
	
}
