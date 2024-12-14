package com.blogs.service;

import java.util.List;

import com.blogs.pojos.BlogPost;

public interface BlogPostService {
//get available posts
	List<BlogPost> getAvailablePosts();

	String deleteBlogPost(Long postId);
}
