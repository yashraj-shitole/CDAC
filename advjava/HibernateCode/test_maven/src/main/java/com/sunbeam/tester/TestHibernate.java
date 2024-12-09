package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.utils.HibernateUtils;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;


public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory() ) {
			System.out.println("Hibernate up n running !!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
