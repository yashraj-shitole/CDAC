package com.cdac.tester;

import org.hibernate.SessionFactory;

import com.cdac.utils.HibernateUtils;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running !!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
