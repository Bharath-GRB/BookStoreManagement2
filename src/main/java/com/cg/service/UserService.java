package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public String addUser(User user) {
		userRepository.saveAndFlush(user);
		return "Login Successfully";
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}

	public String validateUserNew(User user) {
		User user1 = null;

		user1 = userRepository.findByUserId(user.getUserId());
		if (user1.getEmail().equals(user.getEmail()) && user1.getPassword().equals(user.getPassword())
				&& user1.getRole().equals(user.getRole())) {
			return "Login Successful";

		} else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	public User updateUser(@RequestBody User user) {
		if (!userRepository.existsById(user.getUserId())) {
			throw new UserNotFoundException("User not found");
		} else {
			User u = userRepository.findById(user.getUserId()).get();
			u.setUserId(user.getUserId());
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			u.setRole(user.getRole());
			userRepository.save(u);

			return u;
		}
	}

}
