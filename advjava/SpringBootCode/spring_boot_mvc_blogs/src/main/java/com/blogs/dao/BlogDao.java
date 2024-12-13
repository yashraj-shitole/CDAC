package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.BlogPost;

public interface BlogDao extends JpaRepository<BlogPost, Long > {

}
