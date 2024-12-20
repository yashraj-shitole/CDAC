package com.blogs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostReqDTO;
import com.blogs.service.BlogPostService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class BlogPostController {
	/*
	 * Using Spring preferred Ctor based D.I
	 */
	//depcy 
//	@Autowired
	private final BlogPostService blogPostService;
	
//	public BlogPostController() {
//		System.out.println("in ctor " + getClass());
//	}
	/*
	 * Desc - Add new Blog Post
	 *  URL - http://host:port/posts
	 * Method - POST 
	 * payload - BlogPostDTO (category Id , author id , title content , desc) 
	 * Successful Resp - SC 201 + mesg (ApiResponse)
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 */
	@PostMapping
	@Operation(description = "Add New Blog")
	public ResponseEntity<?> addBlogPost
	(@RequestBody BlogPostReqDTO dto) {
		System.out.println("in add post "+dto);
		try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(blogPostService.postNewBlog(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
					
		}
	}
	/*
	 * Desc - Get all  Blog Posts by user
	 *  URL - http://host:8081/posts/blogger/{bloggerId}
	 * Method - GET 
	 * 	Successful Resp - SC 200 + List<BlogPostDTO>
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 */
	@GetMapping("/blogger/{bloggerId}")
	public ResponseEntity<?> getPostByAuthor(@PathVariable Long bloggerId)
	{
		return ResponseEntity.ok(blogPostService.getPostByAuthor(bloggerId));
	}
	
	/*
	 * Desc - Get all  Blog Postser
	 *  URL - http://host:8081/posts
	 * Method - GET 
	 * 	Successful Resp - SC 200 + List<BlogPostDTO>
	 * 
	 */
	@GetMapping
	public ResponseEntity<?> getAllPosts()
	{
		return ResponseEntity.ok(blogPostService.getAllPosts());
	}
	

}
