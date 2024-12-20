package com.users.service;

import com.users.dto.AuthRequest;
import com.users.dto.UserDTO;

import jakarta.validation.Valid;

public interface UserService {
//user signin
	UserDTO authenticateUser(AuthRequest dto);
	//sign up 
	UserDTO signUp(@Valid UserDTO dto);
	UserDTO getUserDetails(Long userId);
	UserDTO getUserDetailsWithBlogs(Long userId);
	
}
