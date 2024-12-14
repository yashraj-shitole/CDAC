package com.blogs.controller;

import java.nio.channels.FileChannel.MapMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.dao.BlogDao;
import com.blogs.dao.CategoryDao;
import com.blogs.pojos.BlogPost;
import com.blogs.pojos.Category;
import com.blogs.service.BlogsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/blogger")
public class BlogsController {

	
	@Autowired
	private BlogsService blogservice;
	
	@Autowired
	private BlogDao blogDao;
	
	@GetMapping("/home")
	public String signUpUser( Model map) {
		System.out.println("in blogger home");
		
		List<BlogPost> blogsList=blogDao.findAll();
		
		map.addAttribute("blogs_list",blogsList);
		
		
		return "/blogger/home";
	}
	
	
	
	@GetMapping("/addblog")
	public String addBlog() {
		System.out.println("in addblog");
		
		return "/blogger/addblog";
	}
	
	@PostMapping("/addblog")
	public String postMethodName(@RequestParam String title,@RequestParam String content,@RequestParam String description,@RequestParam Long categoryId,@RequestParam Long userId) {
		
		System.out.println(categoryId);
		boolean added=blogservice.addBlog(title,content,description,categoryId,userId);
		
		
		//adding categories with bidirection reference
		
		return "redirect:/blogger/home";
	}
	
	
}
