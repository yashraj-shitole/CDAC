package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.service.CategoryService;


@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	public CategoryController() {
	System.out.println("in const of "+getClass());
	}
	
	
	@GetMapping("/display")
	public String renderCategoryList(Model modelMap) {
		
		System.out.println("In category display"+ modelMap);
		
		//invoke service layer method will get list of categories add it under modelMap
		modelMap.addAttribute("category_list", categoryService.getAllCategories());
		
		
		return "/categories/display";
	}
	
	

}
