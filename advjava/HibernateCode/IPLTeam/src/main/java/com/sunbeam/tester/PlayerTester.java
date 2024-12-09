package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImp;
import com.sunbeam.entities.Player;

public class PlayerTester {

	
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			
			
			
			
		int choice=0;
			
			while (true) {
				
				System.out.println("0. EXIT\n"
								+ "1. Add Player\n"
								+ "2. Display all players\n"
								+ "3. Get all players from specified team\n"
								+ "4. Display team owner names requiring max age, batting average\n"
								+ "5. Display team owner names and team abbreviations requiring max age, batting average\n"
								+ "6. Update max age requirement\r\n"
								+ "7. Delete team details");
				
					
				
				choice=sc.nextInt();
				
				switch (choice) {
				
				case 0:
					System.out.println("Thank you for using app!!");
					return;
				case 1:
						addPlayer();
					break;
					
				case 2:
						displayAllPlayers();
					break;
					
				case 3:
						displayPlayersFromTeam();
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				case 6:
					break;
					
				case 7:
					break;

				default:
					break;
				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void displayPlayersFromTeam() {
		
		PlayerDao playerdao=new PlayerDaoImp();
		
				
		
	}

	private static void displayAllPlayers() {
		
		PlayerDao playerDao=new PlayerDaoImp();
		
		playerDao.getAllPlayers().forEach(System.out::println);
		
	}

	private static void addPlayer() {
		
		Scanner sc=new Scanner(System.in);
		
		PlayerDao playerDao=new PlayerDaoImp();
		
		System.out.println("Enter first name");
		String firstName=sc.next();
		System.out.println("Enter last name");
		String lastName=sc.next();
		System.out.println("Enter dob YYYY-MM-DD");
		LocalDate dob=LocalDate.parse(sc.next());
		System.out.println("Enter batting average");
		double battingAvg=sc.nextDouble();
		System.out.println("Enter wickets taken");
		int wicketTaken=sc.nextInt();
		System.out.println("Enter team id to add into team");
		Long teamId=sc.nextLong();
		
		
		Player player=new Player(firstName, lastName, dob, battingAvg, wicketTaken, null);
		
		playerDao.addPlayer(player,teamId);
		
		
//	    Player player1 = new Player("Rohit", "Sharma", LocalDate.of(1987, 4, 30), 48.0, 150, null);
//        playerDao.addPlayer(player1, 1L);
//
//        Player player2 = new Player("Virat", "Kohli", LocalDate.of(1988, 11, 5), 50.0, 200, null);
//        playerDao.addPlayer(player2, 2L);
//
//        Player player3 = new Player("MS", "Dhoni", LocalDate.of(1977, 7, 7), 40.0, 100, null);
//        playerDao.addPlayer(player3, 3L);
//
//        Player player4 = new Player("Suresh", "Raina", LocalDate.of(1986, 11, 27), 35.0, 50, null);
//        playerDao.addPlayer(player4, 4L);
//
//        Player player5 = new Player("Andre", "Russell", LocalDate.of(1988, 7, 29), 30.0, 250, null);
//        playerDao.addPlayer(player5, 5L);
//
//        Player player6 = new Player("Sunil", "Narine", LocalDate.of(1988, 4, 2), 15.0, 300, null);
//        playerDao.addPlayer(player6, 6L);
		
	}
	
	
}
