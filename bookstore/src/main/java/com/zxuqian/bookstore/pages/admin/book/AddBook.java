package com.zxuqian.bookstore.pages.admin.book;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.SelectModelFactory;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.apache.tapestry5.upload.services.UploadedFile;

import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Category;
import com.zxuqian.bookstore.entities.Inventory;
import com.zxuqian.bookstore.services.BookService;
import com.zxuqian.bookstore.services.CategoryService;

@Import(library = "context:admin/book.js")
public class AddBook {
	
	private static final String UPLOAD_FOLDER = "bookstore_upload";
	
	@Inject
	@Path("context:layout/admin/js/demo/demo.formelements.js")
	private Asset formScript;
	
	@Environmental
	private JavaScriptSupport javascriptSupport;
	
	/**
	 * 类别selectModelFactory
	 */
	@Inject
	private SelectModelFactory selectModelFactory;
	
	/**
	 * 类别Service
	 */
	@Inject
	private CategoryService categoryService;
	
	/**
	 * 类别实体
	 */
	@Property
	private Category category;
	
	/**
	 * 图书实体
	 */
	@Property
	private Book book;
	
	/**
	 * 库存实体
	 */
	@Property
	private Inventory inventory;
	
	/**
	 * 上传的文件
	 */
	@Property
	private UploadedFile file;
	
	/**
	 * 应用全局信息
	 */
	@Inject
	private ApplicationGlobals applicationGlobals;
	
	/**
	 * BookService
	 */
	@Inject
	private BookService bookService;
	
	@AfterRender
	void afterRender() {
		javascriptSupport.importStack("bookStack");
		javascriptSupport.importJavaScriptLibrary(formScript);
	}
	
	void onPrepareFromBookForm() {
		this.book = new Book();
		this.inventory = new Inventory();
		
	}
	
	void onSuccessFromBookForm() {
		File copied = this.getFileUploadFile();
		file.write(copied);
		
		this.book.setCategory(this.category);
		this.book.setInventory(this.inventory);
		this.book.setAttachment(copied.getName());
		
		System.out.println(book);
		bookService.addBook(book);
	}
	
	void onUploadException(FileUploadException ex) {
		System.out.println(ex.getMessage());
	}
	
	/**
	 * select组件
	 */
	public SelectModel getCategories() {
		List<Category> treeCategory = new ArrayList<Category>();
		
		this.categoryService.getTreeCategories(treeCategory, this.categoryService.getReadOnlyCategories(), "");
		
		return this.selectModelFactory.create(treeCategory, "name");
	}
	
	/**
	 * 创建上传文件保存目录，并返回
	 * @param file 上传的文件
	 * @return 保存的上传文件路径
	 */
	public File getFileUploadFile() {
		//获取随机生成的文件名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = sdf.format(new Date());
		String fileName = date + System.currentTimeMillis() + new Random(System.currentTimeMillis()).nextInt(5000);
		String extName = this.file.getFileName().substring(this.file.getFileName().lastIndexOf("."));
		
		String applicationPath = applicationGlobals.getServletContext().getRealPath("/");
		File upload = new File(new File(applicationPath).getParentFile().getPath() + "/" + UPLOAD_FOLDER);
		if(!upload.exists()) {
			upload.mkdir();
		}
		File uploadFile = new File(upload.getPath() + "/" + (fileName + extName));
		return uploadFile;
	}

}
