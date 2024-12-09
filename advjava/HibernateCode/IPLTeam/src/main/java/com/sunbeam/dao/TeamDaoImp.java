package com.sunbeam.dao;

import com.sunbeam.entities.IPLTeam;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class TeamDaoImp implements TeamDao {

	@Override
	public String addTeam(IPLTeam team) {
		String msg="Team not added";
		
		 Session session=getSessionFactory().getCurrentSession();
			
		 Transaction tx=session.beginTransaction();
		 
		 try {
			 
			 Serializable teamId=session.save(team);
			 tx.commit();
			 
			 msg="Team added. Team Id: "+teamId; 
			 
		 }
		 catch (RuntimeException e) {
			 if (tx!=null) {
				tx.rollback();
			}
			 throw e;
			
			 
		}
		
		
		return msg;
	}

	@Override
	public List<IPLTeam> getAllTeams() {
		
		List<IPLTeam> team=null;
		
		String jpql="select team from IPLTeam team";
		
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx= session.beginTransaction();
		
		
		try {
			
			team=session.createQuery(jpql, IPLTeam.class).getResultList();
			
			tx.commit();
			
			
		}catch (RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			
			throw e;
		}
		
		
		
		
		return team;
	}

	@Override
	public List<IPLTeam> getTeamsWithMaxAge(int maxAge,double battingAvg) {
		
		List<IPLTeam> teams=null;
		
		String jpql="select team from IPLTeam team where maxPlayerAge<:age and battingAvg<:batAvg";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			
			teams=session.createQuery(jpql, IPLTeam.class)
					.setParameter("age", maxAge)
					.setParameter("batAvg", battingAvg)
					.getResultList();
			
			tx.commit();
			
		}catch (RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			throw e;		
		}
		return teams;
	}

	@Override
	public List<String> getTeamOwnerMaxAgeAvgBatting(int maxAge, double minBattingAverage) {
		
		List<String> teams=null;
		
		String jpql="select team.owner from IPLTeam team where maxPlayerAge<:age and battingAvg>:batAvg";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			teams=session.createQuery(jpql,String.class)
					.setParameter("age", maxAge)
					.setParameter("batAvg", minBattingAverage)
					.getResultList();
			
			
			tx.commit();

		}catch (RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			
			throw e;
			
		}
		
		
		return teams;
	}

	@Override
	public Iterable<IPLTeam> getTeamOwnerAbbrevation(int maxAge, double minBattingAverage) {
		

		List<IPLTeam> teams=null;
		
		String jpql="select new com.sunbeam.entities.IPLTeam(owner,abbrevation) from IPLTeam team where maxPlayerAge<:age and battingAvg>:batAvg";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			teams=session.createQuery(jpql,IPLTeam.class)
					.setParameter("age", maxAge)
					.setParameter("batAvg", minBattingAverage)
					.getResultList();
			
			
			tx.commit();

		}catch (RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			
			throw e;
			
		}
		
		
		return teams;
	}

	@Override
	public void UpdateTeamAge(String teamName, int maxAge) {
		
		String jpql="select team from IPLTeam team where name=:teamName";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			IPLTeam team=session.createQuery(jpql,IPLTeam.class)
					.setParameter("teamName", teamName)
					.getSingleResult();
			
			team.setMaxPlayerAge(maxAge);
			
			tx.commit();
		} catch (RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			System.out.println("Team not found!!!");
		}
		
	}

	@Override
	public void deleteTeam(Long teamId) {
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			IPLTeam team=session.get(IPLTeam.class, teamId);
			
			if(team!=null) {
				System.out.println("Team "+ team.getName() +" deleted");
				session.delete(team);
			}
			else {
				System.out.println("Team with "+teamId+" not found");
			}
			
			tx.commit();
			
		} catch (RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
	}

	
}
