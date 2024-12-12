package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //mandatory
//singleton n eager spring bean
public class HomeController {
	public HomeController() {
		System.out.println("in ctor "+getClass());
	}
	//request handling method to render home page 
	//URL - http://localhost:8080/spring_mvc_template/
	@GetMapping("/")
	public String renderHomePage() {
		System.out.println("in render home page");
		return "/index";//LVN - /index , AVN - /WEB-INF/views/index.jsp
	}

}
