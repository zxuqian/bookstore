package com.zxuqian.bookstore.pages.admin.category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.services.SelectModelFactory;

import com.zxuqian.bookstore.entities.Category;
import com.zxuqian.bookstore.services.CategoryService;

public class EditCategory{
	
	@Property
	@Persist(PersistenceConstants.CLIENT)
	private Category category;
	
	@Property
	@Persist(PersistenceConstants.CLIENT)
	private Category parent;
	
	@Inject
	private CategoryService categoryService;
	
	@Persist(PersistenceConstants.FLASH)
	@Property
	private boolean success;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String msg;
	
	@Inject
	private SelectModelFactory selectModelFactory;
	
	public void onSubmit() {
		//保存修改后的类别
		this.category.setParent(parent);
		success = this.categoryService.saveOrUpdate(category);
		
		//保存成功
		if(success) {
			this.msg = "保存成功";
		} else {
			this.msg = "保存失败";
		}
	}
	
	void onActivate(long categoryId) {
		this.category = categoryService.getCategoryById(categoryId);
		this.parent = this.category.getParent();
	}

	/**
	 * 获取所有类别
	 * @return
	 */
	public SelectModel getCategories() {
		
		List<Category> treeCategory = new ArrayList<Category>();
		
		this.categoryService.getTreeCategories(treeCategory, this.categoryService.getReadOnlyCategories(), "");
		
		SelectModel selectModel = this.selectModelFactory.create(treeCategory, "name");
		
		return selectModel;
	}
}
