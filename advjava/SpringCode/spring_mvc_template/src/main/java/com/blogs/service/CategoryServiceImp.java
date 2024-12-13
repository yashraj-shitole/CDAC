package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.CategoryDao;
import com.blogs.pojos.Category;


@Service //mandetory - service layer spring bean
@Transactional
public class CategoryServiceImp implements CategoryService {

	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
