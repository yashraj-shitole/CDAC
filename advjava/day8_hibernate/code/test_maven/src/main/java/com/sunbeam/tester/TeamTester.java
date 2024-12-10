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
				
				System.out.println("0.EXIT\n"
						+ "1. Add Team\n"
						+ "2. Display all teams\n"
						+ "3. Display all teams requiring max age \n"
						+ "4. Display team owner names and team abbreviations requiring max age\n"
						+ "5. Update max age requirement\r\n"
						+ "6. Delete team details");
				
				choice=sc.nextInt();
				
				switch (choice) {
				
				case 0:
					return;
				case 1:
						addTeam();
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					break;
					
				case 4:
					
					break;
					
				case 5:
					
					break;
					
				case 6:
					
					break;

				default:
					break;
				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void addTeam() {
		Scanner sc=new Scanner(System.in);
		TeamDao teamDao=new TeamDaoImp();
		System.out.println("Team Name, Abbrevation,Owner,Max Player Age,Batting Average,wicketsTaken");
		
		sc.nextLine();
		String name=sc.nextLine(); 
		
		String abbrevation=sc.next();
		
		sc.nextLine();
		String owner=sc.nextLine(); 
		int maxPlayerAge=sc.nextInt();
		double battingAvg=sc.nextDouble();
		int wicketsTaken=sc.nextInt();
		
		IPLTeam team=new IPLTeam(name, abbrevation, owner, maxPlayerAge, battingAvg, wicketsTaken);
		System.out.println(teamDao.addTeam(team));
	}
	

}
