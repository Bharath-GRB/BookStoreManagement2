package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.BookOrder;
import com.cg.entity.Customer;
import com.cg.entity.OrderDetails;
import com.cg.entity.Book;


@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Integer>{
	@Query("select o from OrderDetails o where o.customer.getCustomerId()=customer.getCustomerId()")
	public List<OrderDetails>listOrderByCustomer(Customer customer);
		
	@Query("select o from OrderDetails o where o.book.getBookId()=book.getBookId()")
	public List<OrderDetails>viewOrderByBook(Book book);
	

}
