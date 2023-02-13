package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;
import com.cg.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {
	@Mock
	CustomerRepository customerrepo;

	@InjectMocks
	private CustomerService customerService;

	@Test
	public void getAllCustomerTest() {
		List<Customer> list = new ArrayList<Customer>();
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		list.add(c1);
		list.add(c2);
		when(customerService.getAllCustomers()).thenReturn(list);
		assertEquals(2,customerService.getAllCustomers().size());
		

	}

}
