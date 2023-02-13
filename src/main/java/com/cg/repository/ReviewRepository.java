package com.cg.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Book;
import com.cg.entity.Customer;
import com.cg.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	  @Query("select r from Review r where r.book.getBookId()=book.getBookId()")
	  public List<Review> listAllReviewsByBook(Book book);
	 
	 @Query("select r from Review r where r.customer.getCustomerId()=customer.getCustomerId()") 
	 public List<Review> listAllReviewsByCustomer(Customer customer);
	 
}