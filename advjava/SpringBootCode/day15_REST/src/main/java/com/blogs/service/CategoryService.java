package com.blogs.service;

import java.util.List;

import com.blogs.pojos.Category;

public interface CategoryService {
//get all categories
	List<Category> getAllCategories();
	//add new category
	String addNewCategory(Category category);
}
