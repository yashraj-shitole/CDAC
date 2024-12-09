package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoimpl;

public class DeleteUserDetailsById {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			UserDao userDao=new UserDaoimpl();
			System.out.println("Enter user id to un subscribe");			
			System.out.println(userDao.deleteUserDetails(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
