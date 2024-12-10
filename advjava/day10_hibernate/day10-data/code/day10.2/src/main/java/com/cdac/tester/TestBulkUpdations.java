package com.cdac.tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoimpl;
import com.cdac.entities.User;
import com.cdac.entities.UserRole;
import com.cdac.utils.HibernateUtils;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class TestBulkUpdations {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao userDao = new UserDaoimpl();
			System.out.println("Enter Dob n discount ");
			System.out.println(userDao
					.applyDiscount(LocalDate.parse(sc.next()),sc.nextDouble()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
