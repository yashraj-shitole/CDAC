package com.blogs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.BlogPost;

public interface BlogPostDao extends JpaRepository<BlogPost,Long>{
//find all available posts by author
	List<BlogPost> findByStatusTrueAndBloggerId(Long bloggerId);
}
