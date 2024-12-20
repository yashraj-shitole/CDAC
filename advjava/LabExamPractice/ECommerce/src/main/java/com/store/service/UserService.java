package com.store.service;

import java.util.List;

import com.store.dto.UserDTO;
import com.store.pojo.User;

public interface UserService {

	String addUser(UserDTO userDto);

	List<User> getAllUsers();

	
	
}
