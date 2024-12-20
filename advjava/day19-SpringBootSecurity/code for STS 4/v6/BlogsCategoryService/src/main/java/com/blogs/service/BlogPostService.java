package com.blogs.service;

import java.util.List;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostReqDTO;
import com.blogs.dto.BlogPostRespDTO;

public interface BlogPostService {
	ApiResponse postNewBlog(BlogPostReqDTO requestDTO);

	List<BlogPostRespDTO> getPostByAuthor(Long authorId);

	List<BlogPostRespDTO> getAllPosts();
}
