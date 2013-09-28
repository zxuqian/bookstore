package com.zxuqian.bookstore.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.zxuqian.bookstore.dao.CategoryDao;
import com.zxuqian.bookstore.entities.Category;
import com.zxuqian.bookstore.util.DaoException;

public class CategoryDaoImpl implements CategoryDao {
	@Inject
	private Session session;
	
	public void saveOrUpdate(Category category){
		try {
			this.session.saveOrUpdate(category);
		} catch (HibernateException e) {
			throw new DaoException("保存数据出错");
		} 
	}

	public Category getCategoryById(Long id) {
		
		return (Category)this.session.get(Category.class, id);

	}

	public List<Category> getCategories() {
		return this.session.createQuery("from Category c where c.parent=null").list();
	}

	/**
	 * 为生成类别树用，先清空session缓存，否则会产生数据库更改问题
	 */
	public List<Category> getReadOnlyCategories() {
		this.session.clear();
		List<Category> categories = this.session.createQuery("from Category c where c.parent=null").setReadOnly(true).list();
		return categories;
	}

}
