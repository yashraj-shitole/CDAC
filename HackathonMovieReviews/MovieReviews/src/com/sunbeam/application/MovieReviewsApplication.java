package com.sunbeam.application;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxExpr.ColumnIdentifier;
import com.sunbeam.daoimplimetation.MovieDaoImplimentation;
import com.sunbeam.daoimplimetation.ReviewsDaoImplementation;
import com.sunbeam.daoimplimetation.ShareDaoImplimentation;
import com.sunbeam.daoimplimetation.UserDaoImplementation;
import com.sunbeam.entities.Movies;
import com.sunbeam.entities.Reviews;
import com.sunbeam.entities.Shares;
import com.sunbeam.entities.User;

public class MovieReviewsApplication {

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
			u.setFirst_name(sc.next());
			System.out.println("Enter Last Name");
			u.setLast_name(sc.next());
			System.out.println("Enter email");
			u.setEmail(sc.next());
			System.out.println("Enter mobile");
			u.setMobile(sc.next());
			System.out.println("Enter password");
			u.setPassword(sc.next());
			System.out.println("Enter Date of birth (YYYY-MM-DD)");
			u.setBirth(Date.valueOf(sc.next()));
						
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
				System.out.println("Welcome "+u.getFirst_name()+" "+u.getLast_name());
				logedInUser=u;
				
				userMenu();
				
			}else {
				System.out.println("Login Failed");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void userMenu() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("0. Log Out");
			System.out.println("1. Edit Profile");
			System.out.println("2. Change Password");
			System.out.println("3. Write a Review");
			System.out.println("4. Edit Review");
			System.out.println("5. Display all Movies");
			System.out.println("6. Display all Reviews");
			System.out.println("7. Display my Reviews");
			System.out.println("8. Display Reviews shared with me");
			System.out.println("9. Share a Review");
			System.out.println("10. Delete a Review");
			System.out.println("Enter Choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 0:
				logedInUser = null;
				return;
			case 1:
				editProfile();
				break;
			case 2:
				changePassword();
				break;
			case 3:
				writeReview();
				break;
			case 4:
				editReview();
				break;
			case 5:
				displayAllMovies();
				break;
			case 6:
				displayAllReviews();
				break;
			case 7:
				displayMyReviews();
				break;
			case 8:
				displayReviewsSharedWithMe();
				break;
			case 9:
				shareReview();
				break;
			case 10:
				deleteReview();
				break;
			}
		}
	}


	private static void editProfile() {
		try(UserDaoImplementation udi=new UserDaoImplementation()) {
			
			User u=new User();
			System.out.println("Enter First Name ");
			u.setFirst_name(sc.next());
			System.out.println("Enter Last Name");
			u.setLast_name(sc.next());
			System.out.println("Enter email");
			u.setEmail(sc.next());
			System.out.println("Enter mobile");
			u.setMobile(sc.next());
			System.out.println("Enter Date of birth (YYYY-MM-DD)");
			u.setBirth(Date.valueOf(sc.next()));
			System.out.println("Enter new password");
			u.setPassword(sc.next());
			u.setId(logedInUser.getId());
			
			int count =udi.updateUser(u);
			System.out.println(count);
			
			if (count==1) {
				System.out.println("Profile updated");
			}else {
				System.out.println("Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void changePassword() {
		try(UserDaoImplementation udi=new UserDaoImplementation()) {
			
			System.out.println("Enter new password");
			int c= udi.updatePassword(logedInUser.getId(), sc.next());
			
			if (c==1) {
				System.out.println("Successfull");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void writeReview() {
		try(ReviewsDaoImplementation cdi=new ReviewsDaoImplementation()){
			
			
			displayAllMovies();
			
			
			
		Reviews r=new Reviews();
		System.out.println("Enter movie id");
		r.setMovie_id(sc.nextInt());
		System.out.println("Enter Review");
		sc.nextLine();
		String review=sc.nextLine();
		r.setReview(review);
		System.out.println("Enter rating");
		r.setRating(sc.nextInt());
		System.out.println(logedInUser.getId());
		r.setUser_id(logedInUser.getId());
		int c=cdi.saveReview(r);
		System.out.println("Review saved: "+c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void editReview() {
		try(ReviewsDaoImplementation cdi=new ReviewsDaoImplementation()){
			
		
			displayAllReviews();
			
			
			System.out.println("Enter review id to edit");
			int reviewId=sc.nextInt();
			
			Reviews oldr=cdi.findReviewById(reviewId);
			System.out.println(oldr);
			
			if(oldr!= null) {
				
			System.out.println("Enter review");
			sc.nextLine();
			String review=sc.nextLine();
			oldr.setReview(review);
			
			System.out.println("Enter rating");
			oldr.setRating(sc.nextInt());
			
			
			int c=cdi.updateReview(oldr,logedInUser.getId());
				if(c==1) {
					System.out.println("Review updated: 1");
				}
				else {
					System.out.println("Review update failed");
				}
			}
			else {
				System.out.println("Review not found");
			}
			
			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void displayAllMovies() {
		
	try(MovieDaoImplimentation cdi=new MovieDaoImplimentation()){
			
			ArrayList<Movies> candidateList=new ArrayList<>();
			candidateList=cdi.displayAllMovies();
			candidateList.forEach(System.out::println);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	private static void displayAllReviews() {
		try(ReviewsDaoImplementation cdi=new ReviewsDaoImplementation()){
			
			ArrayList<Reviews> candidateList=new ArrayList<>();
			candidateList=cdi.findAllReviews();
			candidateList.forEach(System.out::println);;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private static void displayMyReviews() {
		try(ReviewsDaoImplementation cdi=new ReviewsDaoImplementation()){
			
			ArrayList<Reviews> candidateList=new ArrayList<>();
			candidateList=cdi.findAllReviewsByUserId(logedInUser.getId());
			candidateList.forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	private static void displayReviewsSharedWithMe() {
		try(ShareDaoImplimentation cdi=new ShareDaoImplimentation()){
			
			ArrayList<Reviews> candidateList=new ArrayList<>();
			candidateList=cdi.displaySharedReviews(logedInUser.getId());
			candidateList.forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private static void shareReview() {

		
	try(ShareDaoImplimentation cdi=new ShareDaoImplimentation()){
			
		System.out.println("Review List");
		displayAllReviews();
		System.out.println();
		System.out.println("User List");
		displayUser();
		
		
		
		
		
		
			System.out.println("Enter id of user to share id with");
			int userid=sc.nextInt();
			
		
			
			
			
			if(userid !=logedInUser.getId()) {
							
				System.out.println("Enter review id");
				int reviewid=sc.nextInt();
				int count=cdi.shareReview(reviewid, userid);
				System.out.println("Successfull");
				
			}
			else {
				System.out.println("Cannot share with oueself");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}	
	
	private static void deleteReview() {
		
		try(ReviewsDaoImplementation cdi=new ReviewsDaoImplementation()){
			
			
			System.out.println("Enter review id to delete");
			int reviewID=sc.nextInt();
			
			Reviews r=cdi.findReviewById(reviewID);
			
			if(r.getUser_id() == logedInUser.getId()) {
				
				int count=cdi.deleteReviewById(reviewID);
				System.out.println("Successful");
			}else {
				System.out.println("Not allowed");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	private static void  displayUser() {
		
		try(UserDaoImplementation udi=new UserDaoImplementation()){

			ArrayList<User> userList=new ArrayList<>();

			userList=udi.findAllUsers();
			userList.forEach(System.out::println);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
