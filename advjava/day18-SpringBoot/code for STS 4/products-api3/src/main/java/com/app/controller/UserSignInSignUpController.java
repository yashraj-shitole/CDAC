package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserSignInSignUpController {
	//depcy
	@Autowired
	private UserService userService;
	/*
	 * Desc - User registration(sign up)
	 * URL - http://host:port/users/signup
	 * Method - POST
	 * Payload - UserDTO
	 * err resp - ApiResp - err mesg
	 * success resp - UserDTO
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody @Valid UserDTO dto)
	{
		System.out.println("in user sign up");
		UserDTO resp = userService.signupUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(resp);
	}

}
