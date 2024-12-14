package com.blogs.service;

import org.springframework.stereotype.Component;

import com.blogs.pojos.BlogPost;

public interface BlogsService {

	boolean addBlog(String title, String content, String description, Long categoryId,Long userId);

	
		
	
}
