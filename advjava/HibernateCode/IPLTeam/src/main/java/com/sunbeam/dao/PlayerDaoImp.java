package com.sunbeam.dao;

import com.sunbeam.entities.IPLTeam;
import com.sunbeam.entities.Player;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.List;
import java.util.Locale.Category;

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

	@Override
	public List<Player> getPlayerFromTeam(Long teamId) {
		List<Player> players=null;
		
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			IPLTeam team=session.get(IPLTeam.class, teamId);
			
			if (team != null) {			
				team.getPlayers().size();
				players=team.getPlayers();
			}
			
			tx.commit();
			
		} catch (Exception e) {
			
			if (tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		
		return players;
	}

	@Override
	public String removePlayer(Long teamId, Long playerId) {
		String msg="Failed to remove";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			IPLTeam team=session.get(IPLTeam.class, teamId);
			

			if (team!=null) {
				
				Player player=session.get(Player.class, playerId);
				
				//checks player is present or not
				if(player!=null) {
					team.getPlayers().size();
					team.getPlayers().remove(player);
					msg="Player deleted!!!";
				}
			}
			
			
			tx.commit();
			
		} catch (RuntimeException e) {
			
			if (tx!=null) {
				tx.rollback();
			}
			
		}
		
		
		
		return msg;
	}
	

}
