package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.pojos.Category;
import com.blogs.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
//depcy
	@Autowired
	private CategoryService categoryService;

	public CategoryController() {
		System.out.println("in ctor " + getClass());
	}

	/*
	 * URL - http://host:port/categories Method - GET payload - none ! resp - JSON
	 * representation of List<Category> Desc - get all categories
	 */
	@GetMapping
	public ResponseEntity<?> getCategories() {
		System.out.println("get all");
		List<Category> categories = categoryService.getAllCategories();
		if (categories.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(categories);
	}

	/*
	 * URL - http://host:port/categories Method - POST payload - JSON representation
	 * of category -> Java - @RequestBody resp - String Desc - add new category
	 */
	@PostMapping
	public ResponseEntity<?> addNewCategory(@RequestBody 
			Category category) {
		System.out.println("in add category " + category);//transient category
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoryService.addNewCategory(category));
	}
}
