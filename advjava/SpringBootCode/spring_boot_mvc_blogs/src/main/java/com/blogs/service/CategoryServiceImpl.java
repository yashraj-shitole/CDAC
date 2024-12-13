package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.CategoryDao;
import com.blogs.pojos.Category;

@Service //mandatory - service layer spring bean
@Transactional
public class CategoryServiceImpl implements CategoryService {
	//depcy - dao layer i/f
	@Autowired //byType
	private CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public void addCategory(String name, String description) {
		
		Category category=new Category(name, description);
		
		categoryDao.save(category);
	}

}
