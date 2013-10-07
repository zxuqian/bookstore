package com.zxuqian.bookstore.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.tapestry5.beaneditor.NonVisual;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NonVisual
	private Long id;
	private String menuName;
	private String url;
	private String icon;
	
	@Column(name = "menu_order")
	private int order;
	
	@ManyToOne
	private Menu parent;
	
	@OneToMany(mappedBy="parent")
	private List<Menu> children;
	
	public Menu() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	
//	public String toString() {
//		return this.getMenuName();
//	}

}
