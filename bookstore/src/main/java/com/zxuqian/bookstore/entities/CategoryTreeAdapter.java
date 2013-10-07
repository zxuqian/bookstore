package com.zxuqian.bookstore.entities;

import java.util.List;

import org.apache.tapestry5.tree.TreeModelAdapter;

public class CategoryTreeAdapter implements TreeModelAdapter<Category> {

	public List<Category> getChildren(Category category) {
		return category.getChildren();
	}

	public String getLabel(Category category) {
		return category == null ? "" : category.getName();
	}

	public boolean hasChildren(Category category) {
		return (null != category.getChildren() && category.getChildren().size() > 0);
	}

	public boolean isLeaf(Category category) {
		return !hasChildren(category);
	}

}
