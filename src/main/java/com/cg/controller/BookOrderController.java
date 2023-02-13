package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Book;
import com.cg.entity.BookOrder;
import com.cg.entity.OrderDetails;
import com.cg.entity.Customer;
import com.cg.service.BookOrderService;


@RequestMapping("/bookorderapi")
@RestController
public class BookOrderController {
	@Autowired

	private BookOrderService bookorderservice;

	@PostMapping("/addBookOrder")
	public String addBookOrder(@Valid @RequestBody BookOrder bookorder)

	{

		return bookorderservice.addBookOrder(bookorder);
	}
	@GetMapping("/getAll")

	public List<BookOrder> getAll()

	{

		return bookorderservice.getAllBookOrders();

	}
	@PutMapping("/update")

	public BookOrder updateUser(@Valid @RequestBody BookOrder bookorder)

	{
		return bookorderservice.updateUser(bookorder);
	}
	@GetMapping("/getlistOrderByCustomer/{stk}")
	public List<OrderDetails>listOrderByCustomer(@PathVariable("stk") Customer customer){
		return bookorderservice.listOrderByCustomer(customer);
	}
	@GetMapping("/viewOrderByBook/{stk}")
	public List<OrderDetails>viewOrderByBook(@PathVariable("stk") Book book){
		return bookorderservice.viewOrderByBook(book);
	}


}
