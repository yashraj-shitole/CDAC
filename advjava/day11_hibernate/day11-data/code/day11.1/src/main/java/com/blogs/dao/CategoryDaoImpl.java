package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.pojos.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category category) {
		String mesg = "adding category failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(category);
			tx.commit();
			mesg = "added new category with id=" + category.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public Category getCategoryDetails(String categoryName) {
		Category category = null;
		String jpql = "select c from Category c where c.categoryName = :nm";
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			category=session.createQuery(jpql, Category.class)
					.setParameter("nm", categoryName)
					.getSingleResult();
			//category : persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return category;//detached
	}

	@Override
	public Category getCategoryDetailsById(Long categoryId) {
		Category category = null;
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// replace get by load n observe !
			category = session.get(Category.class, categoryId);
			// category : persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return category;// detached
	}

	@Override
	public Category getCategoryAndPostDetails(String categoryName) {
		Category category = null;
	//	String jpql = "select c from Category c where c.categoryName = :nm";
		String jpql = "select c from Category c left join fetch c.blogPosts  where c.categoryName = :nm";
		
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			category=session.createQuery(jpql, Category.class)
					.setParameter("nm", categoryName)
					.getSingleResult();//select - categories
			//category - persistent
			//access un fetched data(proxy) from within session scope , before commit
	//		category.getBlogPosts().size();//select - posts
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return category;// detached

	}

}
