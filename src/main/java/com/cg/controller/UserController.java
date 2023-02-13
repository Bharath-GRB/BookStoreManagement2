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

import com.cg.entity.User;

import com.cg.service.UserService;

@RequestMapping("/userapi")
@RestController
public class UserController {
	@Autowired

	private UserService userservice;

	@PostMapping("/addUser")

	public String addUser(@Valid @RequestBody User user)

	{

		return userservice.addUser(user);

	}

	@GetMapping("/getAll")

	public List<User> getAll()

	{

		return userservice.getAllUsers();

	}

	@GetMapping("/getById/{id}")

	public User getUser(@PathVariable("id") int uid)

	{

		return userservice.getUserById(uid);

	}

	@DeleteMapping("/deleteById/{id}")

	public void deleteUser(@PathVariable("id") int id)

	{

		userservice.delete(id);

	}

	@PutMapping("/updateById/{id}")

	public User updateUser(@Valid @RequestBody User user)

	{

		return userservice.updateUser(user);

	}
	

}
