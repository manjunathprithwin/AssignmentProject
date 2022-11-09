package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.UserRepository;
import com.assignment.model.Response;
import com.assignment.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public Response saveUser(User user)
	{
		repository.save(user);
		return new Response("saved user with id" + user.getId(), Boolean.TRUE);
	}
	
	public Response getAllUsers()
	{
		List<User> users = repository.findAll();
		return new Response("number of User:"+ users.size(), Boolean.TRUE);
	}

}
