package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	
	private Book book;

	private int quanitity;

	private double subtotal;
	@OneToOne//(cascade=CascadeType.ALL)
	
	private BookOrder bookorder;

	public OrderDetails() {

	}

	public OrderDetails(Book book, int quanitity, double subtotal, BookOrder bookorder) {
		super();
		this.book = book;
		this.quanitity = quanitity;
		this.subtotal = subtotal;
		this.bookorder = bookorder;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuanitity() {
		return quanitity;
	}

	public void setQuanitity(int quanitity) {
		this.quanitity = quanitity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public BookOrder getBookorder() {
		return bookorder;
	}

	public void setBookorder(BookOrder bookorder) {
		this.bookorder = bookorder;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", book=" + book + ", quanitity=" + quanitity + ", subtotal="
				+ subtotal + ", bookorder=" + bookorder + "]";
	}

}