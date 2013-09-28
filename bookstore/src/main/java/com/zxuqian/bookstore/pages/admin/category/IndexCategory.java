package com.zxuqian.bookstore.pages.admin.category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.services.SelectModelFactory;
import org.slf4j.Logger;

import com.zxuqian.bookstore.entities.Category;
import com.zxuqian.bookstore.services.CategoryService;

public class IndexCategory {
	
	@Property
	private Category category;
	
	@Property
	private Category parent;
	
	@Inject
	private CategoryService categoryService;
	
	@Inject
	private Logger logger;
	
	@Persist(PersistenceConstants.FLASH)
	@Property
	private boolean success;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String msg;
	
	@Inject
	private SelectModelFactory selectModelFactory;
	
	private int tableIndex = 1;
	
	/**
	 * 初始化category对象，render和submit之前
	 */
	public void onPrepare() {
		if(this.category == null) {
			this.category = new Category();
		}
		logger.debug("is category realy null?" + this.category);
	}
	
	/**
	 * 提交保存
	 */
	public void onSubmit() {
		logger.debug("The category name is: " + this.category.getName()
				+ ", and description is: " + category.getDescription());
		
		logger.debug("The parent category name is: " + this.parent.getName());
		
		this.category.setParent(parent);
		
		this.success = categoryService.saveOrUpdate(this.category);
		
		if(this.success) {
			this.msg = "保存成功";
		} else {
			this.msg = "保存失败";
		}
		
	}
	
	
	/**
	 * 获取所有类别
	 * @return
	 */
	public SelectModel getCategories() {
		
		List<Category> treeCategory = new ArrayList<Category>();
		
		this.categoryService.getTreeCategories(treeCategory, this.categoryService.getReadOnlyCategories(), "");
		
		return this.selectModelFactory.create(treeCategory, "name");
	}
	
	/**
	 * 为类别列表组装类别
	 * @return
	 */
	public List<Category> getCategoriesForManagement() {
		List<Category> treeCategory = new ArrayList<Category>();
		
		this.categoryService.getTreeCategories(treeCategory, this.categoryService.getReadOnlyCategories(), "");
		
		return treeCategory;
		
	}
	
	public int getTableIndex() {
		return tableIndex++;
	}

}
