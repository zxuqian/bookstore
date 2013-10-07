package com.zxuqian.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonVisual
	private Long id;
	private Integer quantity;
	private Integer sold;
	private Integer remains;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public Integer getRemains() {
		return remains;
	}
	public void setRemains(Integer remains) {
		this.remains = remains;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", quantity=" + quantity + ", sold="
				+ sold + ", remains=" + remains + "]";
	}
	
}
