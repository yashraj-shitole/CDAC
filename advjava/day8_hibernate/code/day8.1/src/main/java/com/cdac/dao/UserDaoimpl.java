package com.cdac.dao;

import com.cdac.entities.User;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

public class UserDaoimpl implements UserDao {

	@Override
	public String signUpUser(User user) {
		String mesg="User registration failed!!!!!!!!!!";
		// 1. Get Session from SessionFactory
		/*
		 * Method of SessionFactory public Session getCurrentSession() throws
		 * HibernateException
		 */
		Session session = getSessionFactory().getCurrentSession();
		// 2 . Begin a Transaction
		/*
		 * Method of Session 
		 * public Transaction beginTransaction() throws
		 * HibernateException
		 */
		Transaction tx=session.beginTransaction();
		try {
			/*
			 * Session API
			 * public Serializable save(Object transientEntity) throws  HibernateException
			 */
			Serializable userId = session.save(user);
			//=> success
			tx.commit();
			mesg="User signed up ! , ID "+userId;
		} catch (RuntimeException e) {
			// => failure -> rollback the Tx
			if(tx != null)
				tx.rollback();
			//re throw the same exception to the caller
			throw e;
		}
		return mesg;
	}

}
