package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dao.CategoryDao;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CategoryDTO;
import com.blogs.dto.CategoryPostDTO;
import com.blogs.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// depcy
	@Autowired
	private CategoryDao categoryDao;
	// depcy
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategoryDTO> getAllCategories() {
		// ret all categories
		return categoryDao.findAll().stream().map(c -> modelMapper.map(c, CategoryDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO addNewCategory(CategoryDTO dto) {

		// save category details
		Category persistentCategory = categoryDao
				.save(modelMapper.map(dto, Category.class));
		return modelMapper.map(persistentCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO getCategoryDetails(Long categoryId) {
		// return category details
		Category categoryEnt = categoryDao.findById(categoryId) // Optional<Category>
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!!"));

		return modelMapper.map(categoryEnt, CategoryDTO.class);

	}

	@Override
	public ApiResponse updateCategoryDetails(Long categoryId, Category existingCategory) {
		String mesg = "Category Updation Failed : invalid id !!!!";
		// validate - chk if category exists !
		if (categoryDao.existsById(categoryId)) {
			categoryDao.save(existingCategory);
			mesg = "Updated category details";
		}
		return new ApiResponse(mesg);
	}// insert OR update

	@Override
	public ApiResponse deleteCategoryDetails(Long categoryId) {
		if (categoryDao.existsById(categoryId)) {
			categoryDao.deleteById(categoryId);
			return new ApiResponse("Delete category details !");
		}
		return new ApiResponse("Category Deletion failed");
	}

	@Override
	public CategoryPostDTO getCategoryAndPostDetails(Long categoryId) {
		// return category + posts details
		Category categoryEnt = categoryDao.getCategoryAndPosts(categoryId) // Optional<Category>
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!!"));
		return modelMapper.map(categoryEnt, CategoryPostDTO.class);

	}

}
