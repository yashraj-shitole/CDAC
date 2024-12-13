package com.blogs.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * Request URL - http://host:port/ctx_path/test/display
	 * Method - GET
	 * Resp - dynamic resp - local time
	 */
	@GetMapping("/display")
	public ModelAndView testModelAndView() {
		System.out.println("in test m n  v");
		/*
		 * o.s.w.s.ModelAndView - holder of model attribute+LVN
		 * ModelAndView(String lvn , String modelAttrName,Object value)
		 * 
		 */
		return new ModelAndView("/test/display","server_time",LocalTime.now());
		/*
		 * Handler rest MnV ---> D.S sends LVN  --> V.R --> AVN
			(/WEB-INF/views/test/display.jsp)  --> D.S
			are there model attrs ? -- YES --> D.S adds model attribute under request scope
			--> forward s to view layer.
		 */
	}
	/*
	 * Request URL - http://host:port/ctx_path/test/display2
	 * Method - GET
	 * Resp - dynamic resp - local time , list of numbers - 10,20,30,40,50
	 */
	@GetMapping("/display2")
	public String testModelMap(Model modelMap) {
		/*for IoC - simply add Model as the method argument
		 * SC will auto create EMPTY model map n makes it available.
		 */		
		System.out.println("in test model map "+modelMap);//{}
		// n then add model attributes
		//add 2 model attributes under Model map
		/*
		 * o.s.ui.Model - i/f that holds  model attributes
		 * Method - Model addAttribute(String attrName,Object value)
		 */
		modelMap.addAttribute("server_ts", LocalDateTime.now())
		.addAttribute("number_list",List.of(10, 20, 30, 40));
		System.out.println(modelMap);//{.....}
		return "/test/display2";//LVN
		/*
		 * Handler method rets --> LVN(explicitly) + implicitly - Model map -> D.S
		 * D.S ---> sends LVN --> V.R --> AVN :/WEB-INF/views/test/display2.jsp
		 * --> chks for model attributes  --> finds 2 attrs --> adds them under req scope
		 * --> forwards the clnt request to JSP
		 * 
		 */
	}

}
