package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

public class UserDaoImpl implements UserDao {
	// no constructor , no cleanup n no fields are required!

	@Override
	public String registerUser(User newUser) {
		// newUser : TRANSIENT (exisst only in java heap)
		String mesg = "User registration failed !!!!!";
		// 1. Get hibernate session from SessionFactory
		/*
		 * API of SF to get the Session public Session getCurrentSession() throws
		 * HibernateException
		 * 
		 */
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Transaction(Tx)
		/*
		 * Session API public Transaction beginTransaction() throws HibernateException
		 */
		Transaction tx = session.beginTransaction();
		try {
			/*
			 * 3. Session API to insert a record public void persist(Object reference)
			 * throws HibernateException
			 */
			session.persist(newUser);
			// newUser : PERSISTENT (exists in L1 cache , does not DB identity)
			// => success , commit tx
			tx.commit();// insert query(DML)
			/*
			 * What happens internally upon commit ? 1. session.flush() - to synchronize
			 * state of L1 cache with the DB Known as - automatic dirty checking 2. Finds a
			 * new entity in L1 cache -- fires DML (insert) 3. Hibernate auto calls
			 * session.close() 4. As a result , L1 cache is destroyed n pooled out DB
			 * connection simply rets to the pool
			 * 
			 */
			mesg = "User registered with ID" + newUser.getId();
		} catch (RuntimeException e) {
			// In case of a failure , roll back the transaction
			if (tx != null)
				tx.rollback();
			/*
			 * What happens internally upon rollback ?
			 * 
			 * 1. Hibernate auto calls session.close() 2. As a result , L1 cache is
			 * destroyed n pooled out DB connection simply rets to the pool
			 * 
			 */
			// re throw the same exception to caller
			throw e;
		}
		// newUser : DETACHED (does not exist in L1 cache , exists in DB)
		return mesg;
	}

	@Override
	public User getUserDetails(Long userId) {
		User user = null;// user : Does not exist , in heap !
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.get(User.class, userId);
//			user=session.get(User.class, userId);
//			user=session.get(User.class, userId);
			// user (valid id) - PERSISTENT
			// user (invalid id) - Does not exist
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;// user : DETACHED from L1 cache
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users = null;
		String jpql = "select u from User u";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();
//			users=session.createQuery(jpql, User.class)
//					.getResultList();
//			users=session.createQuery(jpql, User.class)
//					.getResultList();
			// users : List of persistent entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return users;// users : List of detached entities
	}

	@Override
	public List<User> getUserDetailsByRoleAndDate(UserRole role, LocalDate date) {
		List<User> users = null;
		String jpql = "select u from User u where u.role = :role1 and u.dob > :dt";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("role1", role).setParameter("dt", date)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return users;
	}

	@Override
	public List<String> getLastNamesByRole(UserRole role1) {
		List<String> lastNames = null;
		String jpql = "select u.lastName from User u where u.role=:rl";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("rl", role1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return lastNames;
	}

	@Override
	public List<User> getDetailsByRole(UserRole role) {
		List<User> users = null;
		String jpql = "select new com.blogs.pojos.User(firstName,lastName,dob) from User u where u.role=:rl";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("rl", role).getResultList();

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return users;
	}

	@Override
	public String changePassword(String email, String oldPassword, String newPass) {
		String mesg = "Changing password failed !!!!";
		User user = null;
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", oldPassword)
					.getSingleResult();
			// => user : PERSISTENT (in case of valid login)
			// throws NoResultException in case of invalid login
			// Modifying state of the PERSISTENT entity (setter)
			user.setPassword(newPass);
			tx.commit();
			mesg = "changed password !";
			/*
			 * session.flush() -> auto dirty checking -> finds updated state of the entity
			 * -> DML (update) session.close() : L1 cache destroyed n DB cn rets to the DBCP
			 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		// user : DETACHED
		user.setPassword("1234567890");// Added ONLY to understand persistent vs detached !
		return mesg;
	}

	@Override
	public String applyDiscount(LocalDate date, double discount) {
		String mesg = "applying discount failed!!!!!";
		String jpql = "update User u set u.regAmount=u.regAmount-:disc where u.dob < :date";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).setParameter("disc", discount).setParameter("date", date)
					.executeUpdate();
			tx.commit();
			mesg = "Applied discount to " + updateCount + " users";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String deleteUserDetails(Long userId) {
		String mesg = "Deleting user details failed";
		User user = null;
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get persistent user from id
			user = session.get(User.class, userId);
			if (user != null) {
				// user : PERSISTENT , mark it for removal
				session.delete(user);
				// user : REMOVED
				mesg = "User details deleted...";
			}
			tx.commit();// user : TRANSIENT
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}
	// user : Does Not exist ! (GC)

	@Override
	public String saveUserImage(String filePath, Long userId) throws IOException {
		String mesg = "Saving user image failed !!!!!";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3 . validate file
			File file = new File(filePath);
			if (file.isFile() && file.canRead()) {
				// 4. get user details from id
				User user = session.get(User.class, userId);
				if (user != null) {
					// 5 . simply call setImage(byte[])
					user.setImage(FileUtils.readFileToByteArray(file));// modifying state of persistent entity
					mesg = "saved image !";
				}
			}
			tx.commit();// DML - update
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String restoreUserImage(String filePath, Long userId) throws IOException {
		String mesg="restoring image failed!!!!!!!!!";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
//3. Get user from id
			User user=session.get(User.class, userId);
			if(user != null)
			{
				//=> user : persistent
				//get image from db
				byte[] imageData=user.getImage();
				if(imageData != null)
				{
					FileUtils.writeByteArrayToFile(new File(filePath), imageData);
					mesg="image resored from db!!!!";
				}
				
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}
	@Override
	public List<User> getUserNamesByCity(String city1) {
		List<User> users = null;
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return users;
	}
	

}
