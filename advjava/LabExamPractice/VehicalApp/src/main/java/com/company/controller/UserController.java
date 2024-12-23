package com.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dao.UserDao;
import com.company.dto.UserDTO;
import com.company.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
	

	
	@Autowired 
	private UserService userService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<?> postMethodName(@RequestBody @Valid UserDTO user) {
		
		System.out.println(user.toString());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}


}
