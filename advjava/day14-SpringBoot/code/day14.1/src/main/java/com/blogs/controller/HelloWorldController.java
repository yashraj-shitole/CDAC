package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //mandatory cls level annotation , to specify that its a spring bean
//containing req handling logic(P.L - presentation logic)
//singleton n eager
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * Request URL - http://host:port/ctx_path/ , method=GET
	 * Resp - render index.jsp
	 */
	/*
	 * SC populates Handler mapping bean @ start up
	 * key - /
	 * value - com.blogs.controller.HelloWorldController.renderWelcomePage
	 */
	@GetMapping("/")
	public String renderWelcomePage() {
		System.out.println("in render welcome page");
		return "/index";//LVN
		/*
		 * Handler rets LVN --> D.S -->LVN -->  V.R --> AVN (/WEB-INF/views/index.jsp)
		 * --> D.S  --> chks for Model Attributes --> no --> D.S simply forwards the 
		 * clnt's request --> AVN
		 * RequestDispatcher rd=request.getRequestDispatcher(AVN);
		 * rd.forward(request,resp);
		 */
	}

}
