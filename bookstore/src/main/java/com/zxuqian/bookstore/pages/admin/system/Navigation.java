package com.zxuqian.bookstore.pages.admin.system;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import com.zxuqian.bookstore.entities.Category;
import com.zxuqian.bookstore.services.CategoryService;

public class Navigation {

	@Environmental
	private JavaScriptSupport javascriptSupport;
	
	@Inject
	@Path("context:admin/navigation.js")
	private Asset asset;
	
	@Inject
	private CategoryService categoryService;
	
	@Property
	private Category category;
	
	@Property
	private List<Category> categories;
	
	public void onActivate() {
		this.categories = this.categoryService.getCategories();
	}
	
	@AfterRender
	public void afterRender() {
		this.javascriptSupport.importJavaScriptLibrary(asset);
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
		
		options.put("sStripeOdd", "xxx");
		
		return options;
	}
	
	/**
	 * 修改有变动的类别
	 */
	public void onSuccessFromAddNavigation() {
		this.categoryService.updateAllCategories(this.categories);
	}
	
}
