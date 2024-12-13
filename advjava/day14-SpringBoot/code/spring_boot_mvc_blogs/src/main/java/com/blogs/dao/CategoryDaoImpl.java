//package com.blogs.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.blogs.pojos.Category;
//
//@Repository //mandatory
//public class CategoryDaoImpl implements CategoryDao {
//	//dependency - EntityManager
//	@Autowired //byType
//	private EntityManager entityManager;
//
//	@Override
//	public List<Category> getAllCategories() {
//		String jpql="select c from Category c";
//		return entityManager
//				.createQuery(jpql,Category.class)
//				.getResultList();
//	}
//
//}
