package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Book;
import com.cg.entity.BookOrder;
import com.cg.entity.Customer;
import com.cg.entity.OrderDetails;

import com.cg.exception.BookOrderNotFoundException;
import com.cg.repository.BookOrderRepository;

@Service
public class BookOrderService {
	@Autowired
	BookOrderRepository bookorderRepository;

	public String addBookOrder(BookOrder bookorder) {
		bookorderRepository.saveAndFlush(bookorder);
		return "Book Order Successfully";
	}

	public List<BookOrder> getAllBookOrders() {
		return bookorderRepository.findAll();
	}

	public List<BookOrder> listAllOrders() {
		return bookorderRepository.findAll();
	}

	public List<OrderDetails> listOrderByCustomer(Customer customer) {
		return bookorderRepository.listOrderByCustomer(customer);
	}

	public List<OrderDetails> viewOrderByBook(Book book) {
		return bookorderRepository.viewOrderByBook(book);
	}

	public BookOrder updateUser(@RequestBody BookOrder bookorder) {
		if (!bookorderRepository.existsById(bookorder.getOrderId())) {
			throw new BookOrderNotFoundException("bookorder not found");
		} else {
			BookOrder b = bookorderRepository.findById(bookorder.getOrderId()).get();
			b.setOrderDate(bookorder.getOrderDate());
			b.setOrderTotal(bookorder.getOrderTotal());
			b.setStatus(bookorder.getStatus());
			b.setPaymentMethod(bookorder.getPaymentMethod());
			b.setRecipientName(bookorder.getRecipientName());
			b.setRecipientPhone(bookorder.getRecipientPhone());

			bookorderRepository.save(b);

			return b;
		}
	}

}
