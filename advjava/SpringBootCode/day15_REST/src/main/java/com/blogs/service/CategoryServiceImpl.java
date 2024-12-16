package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.CategoryDao;
import com.blogs.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	//depcy - dao
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
		return "Added new category with ID="+persistentCategory.getId();
	}
	

}
