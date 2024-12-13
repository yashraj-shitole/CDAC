package com.blogs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.Category;

@Repository //mandatory
public class CategoryDaoImpl implements CategoryDao {
	//dependency - SessionFactory
	@Autowired //byType
	private SessionFactory factory;

	@Override
	public List<Category> getAllCategories() {
		String jpql="select c from Category c";
		return factory.getCurrentSession()
				.createQuery(jpql,Category.class)
				.getResultList();
	}

}
