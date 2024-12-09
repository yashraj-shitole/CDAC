package com.cdac.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		System.out.println("in static init block");
		sessionFactory=new Configuration() //empty hibernate config
				.configure() //reads n loads the props from config file
				.buildSessionFactory();//singleton immutable SF is created !
	}
	//getter
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
