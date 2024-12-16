package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.AuthRequest;
import com.blogs.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	//depcy
	@Autowired
	private UserService userService;
	
	/*
	 * Desc - user sign in
	 * URL - http://host:port/users/signin
	 * Method - POST (for security)
	 * payload -  DTO (email , pwd)
	 * success resp - user details - dto
	 * err resp  - api resp - err mesg
	 * 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody AuthRequest dto)
	{
		System.out.println("in user sign in "+dto);
		try {
			return ResponseEntity.ok(userService.signIn(dto));
		} catch (RuntimeException e) {
			//SC 401 , err mesg
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse(e.getMessage()));
		}
	}

}
