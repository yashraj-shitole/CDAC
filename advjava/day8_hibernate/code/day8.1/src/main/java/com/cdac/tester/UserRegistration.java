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

public class UserRegistration {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			UserDao userDao=new UserDaoimpl();
			System.out.println("Enter user details - String firstName, "
					+ "String lastName, String email, String password, "
					+ "String confirmPassword, LocalDate dob,\r\n"
					+ "			UserRole role, double regAmount");
			User newUser=new User(sc.next(), sc.next(), sc.next(), sc.next(), 
					sc.next(), LocalDate.parse(sc.next()), 
					UserRole.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			System.out.println(userDao.signUpUser(newUser));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
