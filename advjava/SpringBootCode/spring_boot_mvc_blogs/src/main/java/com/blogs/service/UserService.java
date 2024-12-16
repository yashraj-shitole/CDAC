package com.blogs.service;

import java.time.LocalDate;

import com.blogs.pojos.User;




public interface UserService {
	
	User authenticateUser(String email, String password);

	User register(String email, String firstName, String lastName, String address, LocalDate dob, double amount,
			String password);
	
}
