package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
