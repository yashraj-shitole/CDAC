package com.blogs.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //mandatory - spring bean singleton n eager
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor "+getClass());
	}
	//URL - http://host:port/ctx_path/test/test1 , method = GET
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test model n view");
		/*
		 * o.s.w.s.ModelAndView(String LVN , String modeAttrName,Object value)
		 */
		return new ModelAndView("/test/display", 
				"time_stamp", LocalDateTime.now());//AVN - /WEB-INF/views/test/display.jsp
	}

}
