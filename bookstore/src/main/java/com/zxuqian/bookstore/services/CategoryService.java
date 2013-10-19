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
	
	/**
	 * 获取类别树
	 * @param result
	 * @param categories
	 * @param level
	 */
	public void getTreeCategories(List<Category> result, List<Category> categories, String level) {
		
		for(Category category : categories) {
			Category copyCategory = null;
			try {
				copyCategory = (Category)category.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			copyCategory.setName(level + category.getName());
			
			result.add(copyCategory);
			
			if (category.getChildren().size() > 0) {
				getTreeCategories(result, category.getChildren(), "― " + level);
			}
		}
	}
	
	public void delete(Category category) {
		this.categoryDao.delete(category);
	}
	
	public void delete(Long categoryId) {
		this.categoryDao.delete(categoryId);
	}
	
	public List<Category> getAllCategories() {
		return this.categoryDao.getAllCategories();
	}
	
	public void updateAllCategories(List<Category> categories) {
		for(Category category : categories) {
			this.saveOrUpdate(category);
		}
	}

}
