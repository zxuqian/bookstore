package com.zxuqian.bookstore.dao;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.Category;

public interface CategoryDao {
	
	@CommitAfter
	void saveOrUpdate(Category category);
	
	@CommitAfter
	Category getCategoryById(Long id);
	
	@CommitAfter
	List<Category> getCategories();
	
	@CommitAfter
	List<Category> getReadOnlyCategories();
	
	@CommitAfter
	void delete(Category category);
	
	@CommitAfter
	void delete(Long categoryId);
	
	/**
	 * 获取所有类别，包括子类别
	 * @return
	 */
	@CommitAfter
	List<Category> getAllCategories();

}
