package com.blogs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.Category;

@Repository
public class CategoryDaoImp implements CategoryDao{

	@Autowired
	private SessionFactory factory;
	
	
	
	@Override
	public List<Category> getAllList() {
		
		String jpql="select c from Category c";
		
		return factory.getCurrentSession()
				.createQuery(jpql,Category.class)
				.getResultList();
		
	}
	
	

}
