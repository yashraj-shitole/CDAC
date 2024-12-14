package com.blogs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;
import com.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	// depcy
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}

	/*
	 * URL - http://host:port/ctx/users/signin method - POST resp - redirect view
	 * name --> home page
	 */
	@PostMapping("/signin")
	/*
	 * @RequestParam - method arg level annotation , to bind incoming req param to
	 * method argument (reco - match the names !)
	 * 
	 * @RequestParam String email SC => String
	 * email=request.getParameter("email").....
	 * 
	 */
	public String singInUser(@RequestParam String email, 
			@RequestParam String password, HttpSession session) {
		System.out.println("in sign in " + email + " " + password);
		try {
			// invoke service layer method
			User user = userService.authenticateUser(email, password);
			//=> valid login , save user details under session scope
			session.setAttribute("user_details", user);
		// continue to role based authorization
			if(user.getRole()==UserRole.ADMIN)
				return "redirect:/admin/home";
			if(user.getRole()==UserRole.BLOGGER)
				return "redirect:/blogger/home";	
			/*
			 * Handler method rets RVN  --> redirect:/blogger/home -> D.S
			 * D.S sends temp redirect resp -> clnt
			 * SC 302 , Location- http://host:port/ctx/blogger/home
			 * body - EMPTY
			 * Web browser sends a redirect request
			 * URL - http://host:port/ctx/blogger/home , method=GET
			 */
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// in case of invalid login -> redirect the clnt to login page , highlighted
			// with error mesg
			// add a err mesg under session scope
			session.setAttribute("mesg", e.getMessage());
			return "redirect:/";
			// SC -> WC -> response.sendRedirect("/");
		}
		return "";
	}
	/*
	 * URL - http://host:port/ctx/users/logout
	 * Method - GET
	 * resp - render logout page
	 */
	@GetMapping("/logout")
	public String signOut(HttpSession session,Model map
			,HttpServletResponse resp,HttpServletRequest request) {
		System.out.println("in sign out ");
		//1. save user details under Model map
		map.addAttribute("details",session.getAttribute("user_details"));
		//2. invalidate session
		session.invalidate();
		//3. set HTTP resp header - refresh
		resp.setHeader("refresh", "5;url="+request.getContextPath());//refresh - 5;url=/spring_mvc_blogs
		return "/logout";//AVN - /WEB-INF/views/logout.jsp
	}

}
