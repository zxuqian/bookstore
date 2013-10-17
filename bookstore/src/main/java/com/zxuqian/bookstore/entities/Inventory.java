package com.zxuqian.bookstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.hibernate.annotations.Formula;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonVisual
	private Long id;
	private int quantity;
	private int sold;
	@Formula("quantity - sold")
	private int remains;
	@OneToOne
	private Book book;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getRemains() {
		return remains;
	}
	public void setRemains(int remains) {
		this.remains = remains;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", quantity=" + quantity + ", sold="
				+ sold + ", remains=" + remains + "]";
	}
	
}
