package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.CategoryDao;
import com.blogs.dao.CategoryDaoImpl;
import com.blogs.pojos.Category;
import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

/*
 * 2.2 Solve
1. Add a new Category 
i/p : name , description
o/p : mesg

 */
public class AddNewCategory {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			CategoryDao categoryDao = new CategoryDaoImpl();
			System.out.println("Enter category  name ");
			String name=sc.nextLine();
			System.out.println("Enter category  desc");
			String desc=sc.nextLine();
			Category category=new Category(name,desc);
			System.out.println(categoryDao.addNewCategory(category));
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
