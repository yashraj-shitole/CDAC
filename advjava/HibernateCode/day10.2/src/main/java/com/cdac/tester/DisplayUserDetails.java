package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoimpl;

public class DisplayUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			// create user dao instance
			UserDao userDao = new UserDaoimpl();
			userDao.getAllUsers().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
