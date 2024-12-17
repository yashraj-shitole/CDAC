package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostDTO;
import com.blogs.service.BlogPostService;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
//depcy - service layer i.f
	@Autowired
	private BlogPostService blogPostService;
	/*
	 * Desc - add blog post
	 * URL - http://host:port/posts
	 * Method - POST
	 * Payload - dto (blog details + blogger id , category id)
	 * Success resp - Apiresp - success mesg
	 * error resp -  Apiresp - err mesg
	 */
	@PostMapping
	public ResponseEntity<?> addBlogPost(@RequestBody BlogPostDTO dto)
	{
		System.out.println("in add blog post "+dto);
	
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(blogPostService.addBlogPost(dto));
					

	}
}
