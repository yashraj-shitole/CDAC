/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package com.sunbeam;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

public class ElectionApplication {
	public static Scanner sc = null;
	public static User curUser = null;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while(true) {
			System.out.print("0. Exit\n1. Sign In\n2. Sign Up\nEnter choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 0: // Exit
				System.exit(0);
				break;
			case 1: // Sign In
				userAuthentication();
				break;
			case 2: // Sign Up
				userSignUp();
				break;
			}
		}
	}

	private static void userSignUp() {
		try(UserDao userDao = new UserDaoImpl()) {
			System.out.print("Enter first name: ");
			String fName = sc.next();
			System.out.print("Enter last name: ");
			String lName = sc.next();
			System.out.print("Enter email: ");
			String email = sc.next();
			System.out.print("Enter passwd: ");
			String passwd = sc.next();
			System.out.print("Enter birth date (yyyy-MM-dd): ");
			String birth = sc.next();
			Date birthDate = Date.valueOf(birth);
			int status = 0;
			String role = "voter";
			User u = new User(0, fName, lName, email, passwd, birthDate, status, role);
			int count = userDao.save(u);
			System.out.println("User Saved: " + count);
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void userAuthentication() {
		try(UserDao userDao = new UserDaoImpl()) {
			System.out.print("Enter email: ");
			String email = sc.next();
			System.out.print("Enter passwd: ");
			String passwd = sc.next();
			User u = userDao.findByEmail(email);
			if(u != null && u.getPassword().equals(passwd)) {
				System.out.println("Login Successful: " + u);
				curUser = u;
				userMenu();
			} else
				System.out.println("Login Failed");
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void userMenu() {
		while(true) {
			System.out.print("\n0. Sign Out\n1. Show Candidates\n2. Vote\n3. Show Result\nEnter choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 0: // Sign Out
				curUser = null;
				return;
			case 1: // Show Candidates
				showAllCandidates();
				break;
			case 2: // Vote
				
				break;
			case 3: // Show Result
				
				break;
			}
		}
	}

	private static void showAllCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			List<Candidate> list = candDao.findAll();
			list.forEach(System.out::println);
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
