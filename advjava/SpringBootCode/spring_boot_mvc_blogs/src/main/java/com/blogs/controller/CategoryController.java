package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller // mandatory
@RequestMapping("/categories") // optional
public class CategoryController {
//depcy - service layer i.f
	@Autowired // byType - Field level D.I
	private CategoryService categoryService;
	public CategoryController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * Request URL - http://host:port/ctx_path/categories/display
	 * Method - GET
	 * Resp - render the page(JSP) - LVN + model map(category list)
	 */
	@GetMapping("/display")
	public String renderCategoryDisplayPage(Model map)
	{
		System.out.println("in category disp "+map);//{}
		//invoke service layer method --> list --> add it under model map
		map.addAttribute("category_list", categoryService.getAllCategories());
		return "/categories/display";//AVN - /WEB-INF/views/categories/display.jsp
	}
	
	@GetMapping("/addcategory")
	public String addCategory() {
		return "/category/addCategory";
	}
	
	@PostMapping("/addcategory")
	
	public String addcategory(@RequestParam String name, @RequestParam String description) {
		
		categoryService.addCategory(name,description);
		
		return "redirect:/blogger/home";
	}
	
	
}
