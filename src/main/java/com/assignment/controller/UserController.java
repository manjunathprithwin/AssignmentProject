package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Response;
import com.assignment.model.User;
import com.assignment.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService serivce;
	
	@PostMapping("/addUser")
	public Response save(@RequestBody User user)
	{
		return serivce.saveUser(user);
	}
	
	@GetMapping("/getUsers")
	public Response getAllUsers()
	{
		return serivce.getAllUsers();
	}
}
