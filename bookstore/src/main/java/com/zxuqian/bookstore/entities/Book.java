package com.zxuqian.bookstore.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.apache.tapestry5.beaneditor.NonVisual;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonVisual
	private Long id;
	private String name;
	@ManyToOne
	private Category category;
	private Double price;
	@OneToOne
	private Inventory inventory;
	private String isbn;
	private String author;
	private String press;
	private Date publishDate;
	private String overview;
	private String description;
	
	private Date addedDate = new Date();
	
	private String attachment;
	
	public Book() {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", category=" + category
				+ ", price=" + price + ", inventory=" + inventory + ", isbn="
				+ isbn + ", author=" + author + ", press=" + press
				+ ", publishDate=" + publishDate + ", overview=" + overview
				+ ", description=" + description + ", addedDate=" + addedDate
				+ ", attachment=" + attachment
				+ "]";
	}
	
}
