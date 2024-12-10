package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running !!!!");
		} //JVM - sf.close() -> DBCP - cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
