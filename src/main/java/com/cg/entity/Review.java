package com.cg.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="reviews_r")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	
	@OneToOne
	@JoinColumn(name="book_id")
	private Book book;
	 
	@OneToOne
	@JoinColumn(name="cust_id") 
	private Customer customer;
	 
	@Column(name="headline")
	private String headline;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="reviewOn")
	private LocalDate reviewOn;
	
	public Review() {}

	public Review(Book book, Customer customer,String headline, String comment, String rating,
			LocalDate reviewOn) {
		super();
		this.book = book;
		this.customer = customer;
		this.headline = headline;
		this.comment = comment;
		this.rating = rating;
		this.reviewOn = reviewOn;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	
	public Book getBook() { 
		  return book; 
	}
	  
	public void setBook(Book book) { 
		this.book = book;
	}
	 
	
	public Customer getCustomer() { 
		return customer;
	}
	  
	public void setCustomer(Customer customer) { 
		this.customer = customer; 
	}
	 

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public LocalDate getReviewOn() {
		return reviewOn;
	}

	public void setReviewOn(LocalDate reviewOn) {
		this.reviewOn = reviewOn;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", headline=" + headline + ", comment=" + comment
				+ ", rating=" + rating + ", reviewOn=" + reviewOn + "]";
	}
	
}
