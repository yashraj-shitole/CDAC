package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller //mandatory class level annotations
//contains req handling logic(P.L. presentation logic)
public class HelloWorldController {
	
	 public HelloWorldController() {
		 System.out.println("in constructor " +getClass());
		// TODO Auto-generated constructor stub
	}

/* Request URL- http://host:port/ctx_path/, method=GET
*Reponse- render index.jsp
*
*SC populates handler mapping bean @ start up
*key - /
*value- com.IPL.controller.HelloWorldController.renderIndexPage
*/
	 
	 //this will cath the request and send the return response
	 @GetMapping("/")
	 public String renderIndexPage() {
		 	System.out.println("In render index page method");
		 	
		 	
		 	/*
		 	 * Handler returns Logical view name --> 
		 	 * dispatcher servlet --> 
		 	 * logical view name --> 
		 	 * actual view name (WEB-INF/views/index.jsp) -->
		 	 * dispatcher servlet -->
		 	 * checks for model attributes -->
		 	 * dispatcher servlet forwards the clients request -->
		 	 * actual view name .
		 	 * RequestDispatcher rd= request.getRequestDispatcher(actual view name);
		 	 * rd.forward(request,resp);
		 	 * 
		 	 * */
		 	
	 	return "/index";
	 }
	 
	
}
