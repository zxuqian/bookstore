package com.zxuqian.bookstore.pages.admin.book;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.internal.grid.CollectionGridDataSource;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.services.BookService;

public class IndexBook {
	
	@Environmental
	private JavaScriptSupport javascriptSupport;
	
	@Inject
	@Path("context:admin/book.js")
	private Asset bookJs;
	
	/**
	 * 所有图书
	 */
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
	
	/**
	 * ajax table loading bean model source
	 */
	@Inject
	private BeanModelSource beanModelSource;
	
	/**
	 * bean model
	 */
	private BeanModel<Book> model;
	
	/**
	 * compoment resources
	 */
	@Inject
	private ComponentResources resources;
	
	public void afterRender() {
		this.javascriptSupport.importJavaScriptLibrary(bookJs);
	}
	
	/**
	 * 配置datatable
	 * @return
	 */
	public JSONObject getOptions() {
		JSONObject options = new JSONObject();
		
		JSONObject oPaginate = new JSONObject();
		oPaginate.put("sFirst", "首页");
		oPaginate.put("sLast", "尾页");
		oPaginate.put("sNext", "下一页");
		oPaginate.put("sPrevious", "上一页");
		
		JSONObject oLanguage = new JSONObject();
		oLanguage.put("sLengthMenu", "每页显示  _MENU_ 条记录");
		oLanguage.put("sZeroRecords", "对不起，没有找到数据");
		oLanguage.put("sInfo", "显示第 _START_ 到 _END_ 条，共 _TOTAL_ 条记录");
		oLanguage.put("sInfoEmpty", "显示 0 到 0 条， 共 0 条记录");
		oLanguage.put("sInfoFiltered", "(从 _MAX_ 条记录中过滤)");
		oLanguage.put("sSearch", "搜索");
		
		oLanguage.put("oPaginate", oPaginate);
		
		options.put("oLanguage", oLanguage);
		
		return options;
	}
	
	/**
	 * 获取datatable model
	 * @return
	 */
	public BeanModel<Book> getModel() {
		this.model = this.beanModelSource.createDisplayModel(Book.class, resources.getMessages());
		return this.model;
	}
	
	/**
	 * Grid data source
	 * @return
	 */
	public CollectionGridDataSource getBooks() {
		this.books = this.bookService.getAllBooks();
		CollectionGridDataSource cgds = new CollectionGridDataSource(this.books);
		return cgds;
	}
	
	public void onActionFromDelete(Long id) {
		this.bookService.deleteBook(id);
	}
}
