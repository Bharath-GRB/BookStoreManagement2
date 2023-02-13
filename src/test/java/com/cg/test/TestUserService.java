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

import com.cg.entity.User;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;

@ExtendWith(MockitoExtension.class)
public class TestUserService {
	@Mock
	UserRepository urepo;

	@InjectMocks
	private UserService userService;

	@Test
	public void getAllUserTest() {
		List<User> list = new ArrayList<User>();
		User u1 = new User("Vishwa@123", "Vishwa@23", "User");
		User u2 = new User("Naveen@13", "Naveen@kam", "Admin");
		list.add(u1);
		list.add(u2);
		when(userService.getAllUsers()).thenReturn(list);
		assertEquals(2,userService.getAllUsers().size());

	}

}
