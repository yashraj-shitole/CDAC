package com.blogs.dao;

import java.util.List;

import com.blogs.pojos.Category;

public interface CategoryDao {
	//add a method to get list of all categories
	List<Category> getAllCategories();

}
