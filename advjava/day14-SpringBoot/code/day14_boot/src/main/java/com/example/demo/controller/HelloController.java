package com.example.demo.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {
	public HelloController() {
		System.out.println("in ctor " + getClass());
	}
	//URL - http://host:port/ctx_path/ , method=GET
	@GetMapping
	public String showIndexPage(Model map) {
		map.addAttribute("time", LocalTime.now());
		return "/index";//AVN - /WEB-INF/views/index.jsp
	}
	
}
