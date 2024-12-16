package com.blogs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // =@Controller + @ResponseBody : ser.(java -> json/xml)
//spring bean , singleton n eager
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor " + getClass());
	}
	/*
	 * URL - http://host:port/test
	 * Method - GET
	 */
	@GetMapping
	public /* @ResponseBody */ List<Integer> testMe() {
		return List.of(1, 2, 3);
	}
	/*
	 * RestController rets @ResponseBody List --> D.S uses Jackson -ser 
	 * JSON 
	 */
}
