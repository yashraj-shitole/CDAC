package com.sunbeam.dao;

import com.sunbeam.entities.IPLTeam;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

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

}
