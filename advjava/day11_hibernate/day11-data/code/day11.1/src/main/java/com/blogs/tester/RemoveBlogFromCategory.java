package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.BlogPostDao;
import com.blogs.dao.BlogPostDaoImpl;

public class RemoveBlogFromCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			BlogPostDao dao=new BlogPostDaoImpl();
			System.out.println("Enter category id n blog id");			
			System.out.println(dao.removeBlog(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
