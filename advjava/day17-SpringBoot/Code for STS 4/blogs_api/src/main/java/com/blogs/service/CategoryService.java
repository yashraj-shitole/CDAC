package com.blogs.service;

import java.util.List;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.CategoryReqDTO;
import com.blogs.dto.CategoryRespDTO;
import com.blogs.pojos.Category;

public interface CategoryService {
//get all categories dtos
	List<CategoryRespDTO> getAllCategories();
	//add new category
	ApiResponse addNewCategory(CategoryReqDTO category);
	CategoryRespDTO getCategoryDetails(Long catId);
	ApiResponse updateCategory(Long categoryId, Category category);
	ApiResponse deleteCategory(Long categoryId);
}
