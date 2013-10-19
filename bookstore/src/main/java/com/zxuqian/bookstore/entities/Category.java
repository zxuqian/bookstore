package com.zxuqian.bookstore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

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
	
	@OneToMany(mappedBy="parent", cascade=CascadeType.REMOVE)
	private List<Category> children = new ArrayList<Category>();
	
	private boolean navigation;
	
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
				+ description + ", isExpand=" + expand + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Category category = new Category();
		category.setId(this.getId());
		category.setName(this.getName());
		category.setDescription(this.getDescription());
		
		return category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Transient
	private boolean expand;
	
	@Transient
	private String treeName;

	public boolean isExpand() {
		return expand;
	}
	public void setExpand(boolean expand) {
		this.expand = expand;
	}
	
	@Transient
	public boolean isLeaf() {
		if(this.children == null || this.children.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	public String getTreeName() {
		
		String level = "|";
		if(this.parent == null) {
			level = "";
		}
		
		Category category = this;
		while(category.getParent() != null) {
			level = level + "― ";
			category = category.getParent();
		}
		
		return level + this.getName();
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public boolean isNavigation() {
		return navigation;
	}
	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}
	
}
