package com.blogs.service;

import java.util.List;

import com.blogs.dto.ApiResponse;
import com.blogs.pojos.Category;

public interface CategoryService {
//get all categories
	List<Category> getAllCategories();
	//add new category
	String addNewCategory(Category category);
	Category getCategoryDetails(Long catId);
	ApiResponse updateCategory(Long categoryId, Category category);
	ApiResponse deleteCategory(Long categoryId);
}
