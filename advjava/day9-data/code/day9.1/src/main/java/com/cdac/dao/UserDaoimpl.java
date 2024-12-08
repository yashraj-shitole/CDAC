package com.cdac.dao;

import com.cdac.entities.User;
import com.cdac.entities.UserRole;

import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class UserDaoimpl implements UserDao {

	@Override
	public String signUpUser(User user) {
		// user : Transient(exists in heap !)
		String mesg = "User registration failed!!!!!!!!!!";
		// 1. Get Session from SessionFactory
		/*
		 * Method of SessionFactory public Session getCurrentSession() throws
		 * HibernateException
		 */
		Session session = getSessionFactory().getCurrentSession();
		// 2 . Begin a Transaction
		/*
		 * Method of Session public Transaction beginTransaction() throws
		 * HibernateException
		 */
		Transaction tx = session.beginTransaction();
		try {
			/*
			 * Session API public Serializable save(Object transientEntity) throws
			 * HibernateException
			 */
			Serializable userId = session.save(user);
			// user : persistent (exists in L1 , not yet in DB)
			// => success
			tx.commit();
			/*
			 * 1. session.flush() Hibernate performs auto dirty checking -checks state of L1
			 * cache with DB - new entity : insert , updated state : update , removed -
			 * delete (DML) 2. session.close() - L1 cache is destroyed DB cn rets to DBCP
			 */
			// user - Detached (from L1 cache) BUT exists in DB
			mesg = "User signed up ! , ID " + userId;
		} catch (RuntimeException e) {
			// => failure -> rollback the Tx
			if (tx != null)
				tx.rollback();
			/*
			 * 1. session.close() - L1 cache is destroyed DB cn rets to DBCP
			 */
			// re throw the same exception to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public User getUserDetails(Long userid) {
		User user = null;// user : does not exist in heap !
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.get(User.class, userid);// select
//			user=session.get(User.class, userid);
//			user=session.get(User.class, userid);
//			//in case of valid id , user - persistent (exsists in L1 cache , exists in DB)
			tx.commit(); // session.flush() - no DMLs , session.close(); -
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}
		return user;// user - Detached (from L1 cache)
	}

	@Override
	public List<User> getAllUsers() {
		String jpql = "select u from User u";
		List<User> users = null;
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();
			// users - list of persistent entities.
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return users;// users - list of deatched entities.
	}

	@Override
	public List<User> getSelectedUsers(UserRole userRole, LocalDate dob) {
		List<User> users = null;
		String jpql = "select u from User u where u.role=:rl and u.dob > :date";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("rl", userRole).setParameter("date", dob)
					.getResultList();
			// list of persistent entities
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return users;// list of detached entities
	}

	@Override
	public List<String> getLastNames(UserRole role1) {
		List<String> names = null;
		String jpql = "select u.lastName from User u where u.role=:rl";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("rl", role1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return names;
	}

	@Override
	public List<User> getSelectedUsersByRole(UserRole role1) {
		List<User> users = null;
		String jpql = "select new com.cdac.entities.User(firstName,lastName,dob)  from User u where u.role=:role";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("role", role1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return users;
	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
		User user=null;
		String mesg = "Password updation failed !!!!!!";
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user=session.createQuery(jpql, User.class)
					.setParameter("em",email)
					.setParameter("pass",oldPwd)
					.getSingleResult();
			//in case of no results - throws NoResultException
			//user : Persistent (exists L1 cache , exists in db)
			/*
			 * updating state of the persistent entity
			 */
			user.setPassword(newPwd);//user -persistent
			session.evict(user);
			//user - detached
			tx.commit();
			mesg="password changed !";
			/*
			hibernate - session.flush() -> dirty checking -> updated  -> DML - update
			-> session.close() - L1 cache is destroyed n DB cn rets to DBCP
			*/			
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}
		user.setPassword("1234567890");
		/*
		 * hibernate can't track the changes made to the state of Deatched entity
		 */
				
		return mesg;
	}

	@Override
	public String deleteUserDetails(Long userId) {
		String mesg="Deletion failed!!!!!!";
		User user=null;
		// 1. get Session from SessionFactory
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin Tx
		Transaction tx=session.beginTransaction();
		try {
			//get 
			user=session.get(User.class, userId);
			if(user != null)
			{
				//user - persistent
				session.delete(user);
				mesg="deleted user details !";
			}
			tx.commit();
		} catch (RuntimeException e) {
			//roll back the tx
			if(tx != null)
				tx.rollback();
			//re throw the same exception to the caller
			throw e;
		}
	
		return mesg;
	}
	

}
