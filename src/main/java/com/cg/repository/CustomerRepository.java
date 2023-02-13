package com.cg.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Book;
import com.cg.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	  @Query("select cust from Customer cust where cust.book.getBookId()=book.getBookId()") 
	  public List<Customer> listAllCustomersByBook(Book book);
	 
	

}
