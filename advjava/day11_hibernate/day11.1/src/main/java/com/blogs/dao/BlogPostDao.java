package com.blogs.dao;

import com.blogs.pojos.BlogPost;

public interface BlogPostDao {
	// add new blog post to existing category
	String addNewBlogPost(Long categoryId, BlogPost newPost);

	// add a method to remove a blogfrom specified category
	String removeBlog(Long catId, Long blogId);

	// add a method to add new blog to existing category by existing blogger
	String addNewBlog(BlogPost post, Long categoryId, Long bloggerId);

}
