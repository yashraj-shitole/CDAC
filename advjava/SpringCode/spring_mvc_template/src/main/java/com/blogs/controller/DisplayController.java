package com.blogs.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.bytebuddy.matcher.ModifierMatcher.Mode;


@Controller
@RequestMapping("/test")
public class DisplayController {

	public DisplayController() {
		System.out.println("into display constructor "+getClass());
	}

	
	@GetMapping("/display")
	public ModelAndView testModelAndView() {
		System.out.println("into display method ");
		
		/*
		 * o.s.w.s.ModelAndView - holder model attribute + logical view name
		 * ModelAndView(String lvn, String modelAttributeName, Object value)
		 * 
		 * */
		return new ModelAndView("/display", "server_time", LocalDateTime.now());

	}
	
	
	@GetMapping("/display2")
	public String  testModuleMap(Model modeMap) {
		System.out.println("in display2");
		System.out.println("model map "+ modeMap);
		/*
		 * 
		 * o.s.ul.Model- interface that holds model attributes
		 * Method- model addAttribute(String attrName,Object value)
		 * 
		 * 
		 */

		
		modeMap.addAttribute("server_time", LocalDateTime.now()).addAttribute("number_list",List.of(1, 2, 3, 4, 5, 6, 7));
		
		
		return "/display";
	}
	
	
}
