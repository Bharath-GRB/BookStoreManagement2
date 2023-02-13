package com.cg.entity;

import java.io.Serializable; 
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="books")
public class Book //implements Serializable 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Author")
	private String author;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cat_id")
	private Category category;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="Price")
	private String price;
	
	@Column(name="PublishDate")
	private LocalDate publishDate;
	
	@Column(name="UpdatedDate")
	private LocalDate lastUpdatedOn;
	
	@OneToOne(mappedBy="book")
	@JsonIgnore
	private OrderDetails orderdetails;
	
	public Book() {}

	public Book(String title, String author, Category category, String description, String isbn, String price,
			LocalDate publishDate, LocalDate lastUpdatedOn, OrderDetails orderdetails) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdatedOn = lastUpdatedOn;
		this.orderdetails = orderdetails;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public LocalDate getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public OrderDetails getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(OrderDetails orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", description=" + description + ", isbn=" + isbn + ", price=" + price + ", publishDate="
				+ publishDate + ", lastUpdatedOn=" + lastUpdatedOn + ", orderdetails=" + orderdetails + "]";
	}

	}