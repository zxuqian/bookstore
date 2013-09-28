package com.zxuqian.bookstore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.tapestry5.beaneditor.NonVisual;

@Entity
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6266348782458593354L;
	
	@NonVisual
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	
	@ManyToOne
	private Category parent;
	
	@OneToMany(mappedBy="parent")
	private List<Category> children = new ArrayList<Category>();
	
	public Category() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

}
