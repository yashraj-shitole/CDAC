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
import com.blogs.dto.CategoryReqDTO;
import com.blogs.dto.CategoryRespDTO;
import com.blogs.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// depcy - dao
	@Autowired
	private CategoryDao categoryDao;
	//depcy - model mapper
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategoryRespDTO> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll() //List<CategoryEnt>
				.stream() //Stream<Entity>
				.map(category -> modelMapper.map(category, CategoryRespDTO.class)) //Stream<DTO>
				.collect(Collectors.toList());//List<dto>
	}

	@Override
	public ApiResponse addNewCategory(CategoryReqDTO dto) {
		/*
		 * dev steps 
		 * 1. dto -> entity (using model mapper)
		 * 2. save entity
		 * 3. send back dto - api resp
		 */
		Category categoryEntity=modelMapper.map(dto, Category.class);
		Category persistentCategory = categoryDao.save(categoryEntity);
		return new ApiResponse("Added new category with ID="
+ persistentCategory.getId());
	}

	@Override
	public CategoryRespDTO getCategoryDetails(Long catId) {
		Category categoryEntity = categoryDao.
		findById(catId).
		orElseThrow(() -> 
		new ResourceNotFoundException("Invalid Category ID!!!"));
		//convert entity -> dto , using model mapper
		return modelMapper.map(categoryEntity,CategoryRespDTO.class);
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
