package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.pojos.Comment;

public class CommentDaoImpl implements CommentDao {

	@Override
	public String postNewComment(Comment newComment, Long commenterId, Long postId) {
		String mesg = "adding comment failed ....";
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
		return mesg;
	}

	@Override
	public List<Comment> getCommentsByPost(String postTitle) {
		List<Comment> comments = null;
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
		return comments;
	}

}
