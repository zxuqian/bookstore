package com.zxuqian.bookstore.services;

import java.util.List;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.CategoryDao;
import com.zxuqian.bookstore.entities.Category;
import com.zxuqian.bookstore.util.DaoException;

public class CategoryService {
	
	@Inject
	private CategoryDao categoryDao;
	
	public boolean saveOrUpdate(Category category) {
		try {
			this.categoryDao.saveOrUpdate(category);
			return true;
		} catch (DaoException e) {
			return false;
		}
	}
	
	public Category getCategoryById(Long id) {
		return this.categoryDao.getCategoryById(id);
	}
	
	public List<Category> getCategories() {
		return this.categoryDao.getCategories();
	}
	
	public List<Category> getReadOnlyCategories() {
		return this.categoryDao.getReadOnlyCategories();
	}
	
	public void getTreeCategories(List<Category> result, List<Category> categories, String level) {
		
		for(Category category : categories) {
			
			category.setName(level + category.getName());
			
			result.add(category);
			
			if (category.getChildren().size() > 0) {
				getTreeCategories(result, category.getChildren(), "― " + level);
			}
		}
	}

}
