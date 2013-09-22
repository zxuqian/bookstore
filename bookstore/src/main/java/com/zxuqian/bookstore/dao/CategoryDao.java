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

}
