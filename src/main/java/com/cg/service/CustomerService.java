package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public String addCustomer(Customer customer) {
		customerRepository.saveAndFlush(customer);
		return "Customer Added Successfully";
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}

	public void delete(int id) {
		customerRepository.deleteById(id);
	}
	
	  public List<Customer> listAllCustomersByBook(com.cg.entity.Book book){ 
		  return customerRepository.listAllCustomersByBook(book); }
	 

	

	public Customer updateCustomer(@RequestBody Customer customer) {
		if (!customerRepository.existsById(customer.getCustomerId())) {
			throw new CustomerNotFoundException("customer not found");
		} 
		else {
			Customer cust = customerRepository.findById(customer.getCustomerId()).get();
			cust.setMobileNumber(customer.getMobileNumber());
			cust.setFullName(customer.getFullName());
			cust.setRegisterOn(customer.getRegisterOn());
			customerRepository.save(cust);

			return cust;
		}
	}

}