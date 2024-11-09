/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package com.sunbeam;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class JdbcTester4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			List<Candidate> list = candDao.findAll();
			list.forEach(System.out::println);
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			System.out.print("Enter Candidate Id to find: ");
			int id = sc.nextInt();
			Candidate c = candDao.findById(id);
			if(c != null)
				System.out.println("Found " + c);
			else
				System.out.println("Candidate Not Found.");
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			System.out.print("Enter Name: ");
			String name = sc.next();
			System.out.print("Enter Party: ");
			String party = sc.next();
			System.out.print("Enter Votes: ");
			int votes = sc.nextInt();
			Candidate c = new Candidate(0, name, party, votes);
			int cnt = candDao.save(c);
			System.out.println("Candiates Saved: " + cnt);
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			System.out.print("Enter Id (to update): ");
			int id = sc.nextInt();
			System.out.print("Enter Name: ");
			String name = sc.next();
			System.out.print("Enter Party: ");
			String party = sc.next();
			System.out.print("Enter Votes: ");
			int votes = sc.nextInt();
			Candidate c = new Candidate(id, name, party, votes);
			int cnt = candDao.update(c);
			System.out.println("Candiates Updated: " + cnt);
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		*/

		/*
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			System.out.print("Enter Id (to delete): ");
			int id = sc.nextInt();
			int cnt = candDao.deleteById(id);
			System.out.println("Candiates Deleted: " + cnt);
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try(UserDao userDao = new UserDaoImpl()) {
			List<User> list = userDao.findAll();
			list.forEach(System.out::println);
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try(UserDao userDao = new UserDaoImpl()) {
			System.out.print("Enter email: ");
			String email = sc.next();
			System.out.print("Enter passwd: ");
			String passwd = sc.next();
			User u = userDao.findByEmail(email);
			if(u != null && u.getPassword().equals(passwd))
				System.out.println("Login Successful: " + u);
			else
				System.out.println("Login Failed");
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		*/

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
}






