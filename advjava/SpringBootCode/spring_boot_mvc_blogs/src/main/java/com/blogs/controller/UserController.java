package com.blogs.controller;

import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;
import com.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService userService;
	public UserController() {
		System.out.println("in ctor "+getClass());
	}

	@PostMapping("/signin")
	public String singInUser(@RequestParam String email,@RequestParam String password, HttpSession session) {
		System.out.println("in sign in");
		try {
			User user=userService.authenticateUser(email, password);
			session.setAttribute("user_details", user);
			if(user.getRole()==UserRole.ADMIN) {
				return "redirect:/admin/home";
			}
			else {
				return "redirect:/blogger/home";
			}
		} catch (RuntimeException e) {
			System.out.println("Authentication failed: " + e.getMessage());
	        session.setAttribute("msg", "Invalid login credentials. Please try again.");
	        return "redirect:/users/signin";
		}
	}
	
	
	//route to signup
	@GetMapping("/signup")
	public String signUpUser() {
		System.out.println("in signup");
		
		return "/signup";
	}
	
	//accept registration data
	@PostMapping("/register")
	public String register(@RequestParam String email,@RequestParam String password,@RequestParam String dob,@RequestParam String firstName,@RequestParam String lastName, @RequestParam String address,@RequestParam double amount , HttpSession session) {
		System.out.println("in register");
		try {
			
			LocalDate dateOfBirth=LocalDate.parse(dob);
			User user=userService.register(email, firstName,lastName,address,dateOfBirth,amount, password);
			
		
				return "redirect:/users/signin";
			
		} catch (RuntimeException e) {
			System.out.println(e);
			session.setAttribute("msg","Please try again");
			return "redirect://users/signup";	
		}
	}
	
	

}
