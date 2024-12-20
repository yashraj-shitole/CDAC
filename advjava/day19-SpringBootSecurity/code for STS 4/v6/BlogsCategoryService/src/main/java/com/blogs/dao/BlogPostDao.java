package com.blogs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.BlogPost;

public interface BlogPostDao extends JpaRepository<BlogPost, Long> {
//Derived finder
	List<BlogPost> findByBloggerId(Long id);
}
