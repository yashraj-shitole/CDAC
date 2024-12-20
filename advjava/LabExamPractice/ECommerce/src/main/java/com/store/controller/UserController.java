package com.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.UserDTO;
import com.store.pojo.User;
import com.store.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<?> getMethodName() {
		
		List<User> users=userService.getAllUsers();
		
		
		return ResponseEntity.ok(users);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> postMethodName(@RequestBody UserDTO userDto) {
		
		
		String message=userService.addUser(userDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	
	

}
