package com.sunbeam.dao;

import com.sunbeam.entities.IPLTeam;
import com.sunbeam.entities.Player;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class PlayerDaoImp implements PlayerDao {

	@Override
	public String addPlayer(Player player, Long teamId) {
		
		String msg="Failed to add";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			IPLTeam team=session.get(IPLTeam.class, teamId);
			
			if(team!=null) {
				team.getPlayers().add(player);
				player.setPlayerTeam(team);
				
				msg="Player added";
				
				session.persist(player);
			}
			
			tx.commit();
			
			
		} catch (RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			
			throw e;
		}
		
		
		
		
		return msg;
	}

	@Override
	public List<Player> getAllPlayers() {
		
		List<Player> players=null;
		
		String jpql="select players from Player players";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			players=session.createQuery(jpql,Player.class).getResultList();
			
			tx.commit();
			
			
		}catch(RuntimeException e) {
			
			if(tx!=null) {
				tx.rollback();
			}
		}
		
		
		return players;
	}
	

}
