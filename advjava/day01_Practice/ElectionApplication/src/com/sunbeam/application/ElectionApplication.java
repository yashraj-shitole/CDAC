package com.sunbeam.application;

import java.sql.Date;
import java.util.*;

import com.sunbeam.daos.CandidateDaoImplementation;
import com.sunbeam.daos.UserDaoImplementation;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

public class ElectionApplication {

	public static Scanner sc=new Scanner(System.in);
	
	
	public static User logedInUser=null;
	
	public static void main(String[] args) {
		
		int choice =0;
		
		
		while (true) {
			System.out.println("---------------------\n"
							+ "0. EXIT\n"
							+ "1. Login\n"
							+ "2. Signup\n"
							+ "---------------------\n"
							+ "\n"
							+ "Enter your choice");
			choice=sc.nextInt();
			
			switch (choice) {
			case 0:
				return;
			
			case 1:
					login();
				break;
				
			case 2:
					signup();
				break;

			default:
				break;
			}
			
		}
		
		

	}

	private static void signup() {
		
		try(UserDaoImplementation udi=new UserDaoImplementation()) {
			
			User u=new User();
			System.out.println("Enter First Name ");
			u.setFirstName(sc.next());
			System.out.println("Enter Last Name");
			u.setLastName(sc.next());
			System.out.println("Enter email");
			u.setEmail(sc.next());
			System.out.println("Enter password");
			u.setPassword(sc.next());
			System.out.println("Enter Date of birth (YYYY-MM-DD)");
			u.setBirth(Date.valueOf(sc.next()));
			
			u.setStatus(0);
			u.setRole("voter");
			
			int count =udi.saveUser(u);
			System.out.println("User Saved: "+count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	


	private static void login() {

		try(UserDaoImplementation udi=new UserDaoImplementation()){

			System.out.println("Enter email");
			String email=sc.next();
			System.out.println("Enter password");
			String password=sc.next();
			User u=udi.findUserByEmail(email);
			if(u != null && u.getPassword().equals(password)) {
				System.out.println("Welcome "+u.getFirstName()+" "+u.getLastName());
				logedInUser=u;
				
				logedInUserMenu();
				
			}else {
				System.out.println("Login Failed");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void logedInUserMenu() {
		int choice =0;
		
		while(true) {
			System.out.println("-----------------------------\n"
							+ "| 0. SignOut                |\n"
							+ "| 1. Show Candidates        |\n"
							+ "| 2. Cast vote              |\n"
							+ "| 3. Show result            |\n"
							+ "-----------------------------\n"
							+ "\n"
							+ "Enter your choice");
			choice=sc.nextInt();
			
			
			switch(choice) {
			case 0:
				logedInUser=null;
				return;
			case 1:
				showAllCandidates();
				break;
			case 2:
				castVote();
				break;
			case 3:
				showResult();
				break;
				
			}
			
			
		}
		
	}

	private static void showResult() {
		
			try(CandidateDaoImplementation cdi=new CandidateDaoImplementation()){
			
			ArrayList<Candidate> candidateList=new ArrayList<>();
			candidateList=cdi.findAllCandidates();
			candidateList.stream().sorted((x,y)->y.getVotes()-x.getVotes()).forEach(System.out::println);;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void castVote() {
		
		try(CandidateDaoImplementation cdi=new CandidateDaoImplementation()){
			
			if(logedInUser.getStatus()==0) {
				
				System.out.println("Enter candidate id to cast vote");
				int candidateID=sc.nextInt();
				int status= cdi.castVote(candidateID);
				
				//to change status after voting
				if(status==1) {
					System.out.println("Voting successfull");
					logedInUser.setStatus(1);	
					UserDaoImplementation udi=new UserDaoImplementation();
					udi.updateUser(logedInUser);
				}
			
			}
			else {
				System.out.println("You are not eligible for voting");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void showAllCandidates() {
		
		try(CandidateDaoImplementation cdi=new CandidateDaoImplementation()){
			
			ArrayList<Candidate> candidateList=new ArrayList<>();
			candidateList=cdi.findAllCandidates();
			candidateList.forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
