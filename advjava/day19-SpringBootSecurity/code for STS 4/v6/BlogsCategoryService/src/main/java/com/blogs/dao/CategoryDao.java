package com.blogs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blogs.entities.Category;

public interface CategoryDao extends JpaRepository<Category,Long> {
//get category +post details - custom query
	@Query("select c from Category c left join fetch c.posts where c.id=:id")
	Optional<Category> getCategoryAndPosts(Long id);
}
