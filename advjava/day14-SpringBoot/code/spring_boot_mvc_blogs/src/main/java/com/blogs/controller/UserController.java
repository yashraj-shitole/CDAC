package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	//depcy 
	@Autowired
	private UserService userService;
	public UserController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * URL - http://host:port/ctx/users/signin
	 * method - POST
	 * resp - redirect view name --> home page
	 */
	@PostMapping("/signin")
	public String singInUser(@RequestParam String email,@RequestParam String password) {
		System.out.println("in sign in");
		return "";
	}

}
