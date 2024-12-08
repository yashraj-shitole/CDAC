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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
