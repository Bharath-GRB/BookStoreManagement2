package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Book;
import com.cg.entity.Customer;

import com.cg.service.CustomerService;

@RequestMapping("/customerapi")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	@PostMapping("/addCustomer")

	public String addCustomer(@Valid @RequestBody Customer customer)

	{

		return customerservice.addCustomer(customer);

	}

	@GetMapping("/getAll")

	public List<Customer> getAll()

	{

		return customerservice.getAllCustomers();

	}

	@GetMapping("/getById/{id}")

	public Customer getCustomer(@PathVariable("id") int customerId)

	{

		return customerservice.getCustomerById(customerId);

	}

	@DeleteMapping("/deleteById/{id}")

	public void deleteCustomer(@PathVariable("id") int id)

	{

		customerservice.delete(id);

	}

	@PutMapping("/update")

	public Customer updateCustomer(@Valid @RequestBody Customer customer)

	{

		return customerservice.updateCustomer(customer);

	}
	
	  @GetMapping("/listAllCustomersByBook/{nbk}")
	  public List<Customer> listAllCustomersByBook(@PathVariable("nbk")Book book){ 
		  return customerservice.listAllCustomersByBook(book);
	}
	 

}
