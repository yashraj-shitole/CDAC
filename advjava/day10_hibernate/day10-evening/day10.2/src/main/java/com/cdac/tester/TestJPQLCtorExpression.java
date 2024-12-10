package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoimpl;
import com.cdac.entities.UserRole;

public class TestJPQLCtorExpression {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			UserDao userDao=new UserDaoimpl();
			System.out.println("Enter user role");			
			userDao.getSelectedUsersByRole(UserRole.valueOf(sc.next()
					.toUpperCase()))
					.forEach(user -> System.out.println(user.getFirstName()
							+" "+user.getLastName()+" "+user.getDob()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
