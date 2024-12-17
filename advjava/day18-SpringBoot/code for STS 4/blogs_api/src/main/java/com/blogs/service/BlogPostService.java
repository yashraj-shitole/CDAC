package com.blogs.service;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostDTO;

public interface BlogPostService {
	ApiResponse addBlogPost(BlogPostDTO dto);
}
