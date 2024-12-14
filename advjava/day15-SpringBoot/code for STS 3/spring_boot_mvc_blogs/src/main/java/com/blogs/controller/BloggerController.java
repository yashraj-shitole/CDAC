package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blogs.service.BlogPostService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	// depcy - service layer i.f
	@Autowired
	private BlogPostService blogPostService;

	/*
	 * URL -http://localhost:8080/spring_mvc_blogs/blogger/home Method - GET Resp -
	 * render home page
	 */
	@GetMapping("/home")
	public String renderBloggerHomePage(Model map) {
		System.out.println("in render blogger hm page " + map);
		map.addAttribute("posts", blogPostService.getAvailablePosts());
		return "/blogger/home";// AVN /WEB-INF/views/blogger/home.jsp

	}

	/*
	 * URL - http://localhost:8080/spring_mvc_blogs/blogger/delete?postId=....
	 * Method - GET resp - Redirect view name (to redirect the client , in the next
	 * request to home page)
	 * 
	 */
	@GetMapping("/delete")
	public String deleteBlogPost(@RequestParam Long postId,
			RedirectAttributes flashMap) {
		String mesg = null;
		System.out.println("in del post " + postId);
		// invoke blog post'service method
		try {
			mesg = blogPostService.deleteBlogPost(postId);
		} catch (RuntimeException e) {
			mesg = e.getMessage();
		}
		flashMap.addFlashAttribute("mesg", mesg);
		return "redirect:/blogger/home";
	}

}
