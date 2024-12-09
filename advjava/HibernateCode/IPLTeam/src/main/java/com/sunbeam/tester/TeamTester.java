package com.sunbeam.tester;

import java.util.Scanner;


import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImp;
import com.sunbeam.entities.IPLTeam;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;



public class TeamTester {
	
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			
			
			
			
		int choice=0;
			
			while (true) {
				
				System.out.println("0. EXIT\n"
								+ "1. Add Team\n"
								+ "2. Display all teams\n"
								+ "3. Display all teams requiring max age, lowest batting average \n"
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
						addTeam();
					break;
					
				case 2:
					 	displayAllTeams();
					break;
					
				case 3:
						displayTeamsWithMaxAge();
					break;
					
				case 4:
						displayTeamOwnerName();
					break;
					
				case 5:
						displayOwnerAbbrevation();
					break;
					
				case 6:
						updateMaxAge();
					break;
					
				case 7:
						deleteTeam();
					break;

				default:
					break;
				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	


	private static void deleteTeam() {
		Scanner sc=new Scanner(System.in);
		
		displayAllTeams();
		
		System.out.println("Enter team id");
		Long teamId=sc.nextLong();
		
		TeamDao teamDao=new TeamDaoImp();
		
		teamDao.deleteTeam(teamId);
		
	}



	private static void updateMaxAge() {
		Scanner sc=new Scanner(System.in);
		
		TeamDao teamDao=new TeamDaoImp();
		System.out.println("Enter ");
		String teamName=sc.nextLine();
		
		System.out.println("Enter max player age");
		int maxAge=sc.nextInt();
		
		teamDao.UpdateTeamAge(teamName,maxAge);
		
	}



	//display team owner name and abbreviation with min batting average and max age
	private static void displayOwnerAbbrevation() {
		
		
		Scanner sc=new Scanner(System.in);
		
		TeamDao team=new TeamDaoImp();
		System.out.println("Enter max player age");
		int maxAge=sc.nextInt();
		System.out.println("Enter max batting average");
		double minBattingAverage=sc.nextDouble();
		
		team.getTeamOwnerAbbrevation(maxAge,minBattingAverage).forEach(t->System.out.println(t.getOwner()+" "+t.getAbbrevation()));
		
			
	}




	//display team owner name with max age and min batting average 
	private static void displayTeamOwnerName() {
		
		Scanner sc=new Scanner(System.in);
		
		TeamDao team=new TeamDaoImp();
		System.out.println("Enter max player age");
		int maxAge=sc.nextInt();
		System.out.println("Enter max batting average");
		double minBattingAverage=sc.nextDouble();
		
		team.getTeamOwnerMaxAgeAvgBatting(maxAge,minBattingAverage).forEach(System.out::println);
		
		
	}


	
	//display teams with max age and min batting average
	private static void displayTeamsWithMaxAge() {
		Scanner sc=new Scanner(System.in);

		
		TeamDao team=new TeamDaoImp();
		System.out.println("Enter max player age");
		
		int maxAge=sc.nextInt();
		System.out.println("Enter min batting average");
		double battingAvg=sc.nextDouble();
		
		team.getTeamsWithMaxAge(maxAge,battingAvg).forEach(System.out::println);
		
		
		
		
	}


	//display all teams
	private static void  displayAllTeams() {
		
		TeamDao teamDao=new TeamDaoImp();
		
		teamDao.getAllTeams().forEach(System.out::println);
		
	}

	//add a team
	public static void addTeam() {
		Scanner sc=new Scanner(System.in);
		TeamDao teamDao=new TeamDaoImp();
		System.out.println("Team Name, Abbrevation,Owner,Max Player Age,Batting Average,wicketsTaken");
		
		
		String name=sc.nextLine(); 
		
		String abbrevation=sc.next();
		
		sc.nextLine();
		String owner=sc.nextLine(); 
		int maxPlayerAge=sc.nextInt();
		double battingAvg=sc.nextDouble();
		int wicketsTaken=sc.nextInt();
		
		IPLTeam team=new IPLTeam(name, abbrevation, owner, maxPlayerAge, battingAvg, wicketsTaken);
		System.out.println(teamDao.addTeam(team));
		
		
		//IPLTeam team1 = new IPLTeam("Mumbai Indians", "MI", "Nita Ambani", 40, 30, 20);
		//IPLTeam team2 = new IPLTeam("Chennai Super Kings", "CSK", "N Srinivasan", 38, 28, 18);
		//IPLTeam team3 = new IPLTeam("Kolkata Knight Riders", "KKR", "Shah Rukh Khan & Juhi Chawla", 35, 26, 16);
		//IPLTeam team4 = new IPLTeam("Royal Challengers Bangalore", "RCB", "Vijay Mallya", 32, 24, 14);
		//IPLTeam team5 = new IPLTeam("Sunrisers Hyderabad", "SRH", "Kalanithi Maran", 30, 22, 12);
		//IPLTeam team6 = new IPLTeam("Delhi Capitals", "DC", "GMR Group", 28, 20, 10);
		//IPLTeam team7 = new IPLTeam("Rajasthan Royals", "RR", "Manoj Badale", 26, 18, 8);
		//IPLTeam team8 = new IPLTeam("Punjab Kings", "PBKS", "Preity Zinta", 24, 16, 6);
		//IPLTeam team9 = new IPLTeam("Gujarat Titans", "GT", "CVC Capital Partners", 22, 14, 4);
		//IPLTeam team10 = new IPLTeam("Lucknow Super Giants", "LSG", "RPSG Group", 20, 12, 2);
	}
	

}
