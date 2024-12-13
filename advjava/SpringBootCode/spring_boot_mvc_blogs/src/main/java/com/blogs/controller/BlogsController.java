package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.service.BlogsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/blogger")
public class BlogsController {

	
	@Autowired
	private BlogsService blogservice;
	
	@GetMapping("/home")
	public String signUpUser() {
		System.out.println("in blogger home");
		
		return "/blogger/home";
	}
	@GetMapping("/addblog")
	public String addBlog() {
		System.out.println("in addblog");
		
		return "/blogger/addblog";
	}
	
	@PostMapping("/addblog")
	public String postMethodName(@RequestParam String title,@RequestParam String content,@RequestParam String description,@RequestParam Long categoryId) {
		
		System.out.println(categoryId);
		boolean added=blogservice.addBlog(title,content,description,categoryId);
		
		
		return "redirect:/blogger/home";
	}
	
	
}
