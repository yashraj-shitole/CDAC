package com.blogs.service;

import java.util.List;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.CategoryDTO;
import com.blogs.dto.CategoryPostDTO;
import com.blogs.entities.Category;

public interface CategoryService {
	List<CategoryDTO> getAllCategories();
	CategoryDTO addNewCategory(CategoryDTO category);
	CategoryDTO getCategoryDetails(Long categoryId);
	ApiResponse updateCategoryDetails(Long categoryId,Category existingCategory);
	ApiResponse deleteCategoryDetails(Long categoryId);
	CategoryPostDTO getCategoryAndPostDetails(Long categoryId);
}
