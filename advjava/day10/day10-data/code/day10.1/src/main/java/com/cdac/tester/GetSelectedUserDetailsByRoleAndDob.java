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

public class GetSelectedUserDetailsByRoleAndDob {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			UserDao userDao=new UserDaoimpl();
			System.out.println("Enter user role n DoB ");			
			userDao.getSelectedUsers(
					UserRole.valueOf(sc.next().toUpperCase())
					,LocalDate.parse(sc.next())).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
