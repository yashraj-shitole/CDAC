package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.CategoryDao;
import com.blogs.dao.CategoryDaoImpl;
import com.blogs.pojos.Category;

public class GetOrLoadCategoryDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			CategoryDao dao = new CategoryDaoImpl();

			System.out.println("Enter category id to get | load details");
			Category category = dao.getCategoryDetailsById(sc.nextLong());
			System.out.println(category);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
