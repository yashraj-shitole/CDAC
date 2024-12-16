package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dao.CategoryDao;
import com.blogs.dto.ApiResponse;
import com.blogs.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// depcy - dao
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public String addNewCategory(Category category) {
		Category persistentCategory = categoryDao.save(category);
		return "Added new category with ID=" + persistentCategory.getId();
	}

	@Override
	public Category getCategoryDetails(Long catId) {

		return categoryDao.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!"));
	}

	@Override
	public ApiResponse updateCategory(Long categoryId, Category category) {
		if (categoryDao.existsById(categoryId)) {
			// => category id valid
			categoryDao.save(category);// detached --> persistent
			return new ApiResponse("Category updated !");
		}
		return new ApiResponse("Invalid Category ID !!!!");
	}// DML - update

	@Override
	public ApiResponse deleteCategory(Long categoryId) {
		if (categoryDao.existsById(categoryId)) {
			categoryDao.deleteById(categoryId);
			return new ApiResponse("Deleted Category Details");
		}
		throw new ResourceNotFoundException("Invalid Category ID !!!!!!!!");
	}

}
