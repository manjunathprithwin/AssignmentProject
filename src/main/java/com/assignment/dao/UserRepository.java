package com.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
