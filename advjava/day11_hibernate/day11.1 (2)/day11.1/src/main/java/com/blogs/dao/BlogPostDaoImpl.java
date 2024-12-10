package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.pojos.BlogPost;
import com.blogs.pojos.Category;
import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

public class BlogPostDaoImpl implements BlogPostDao {
	@Override
	public String addNewBlogPost(Long categoryId, BlogPost newPost) {
		String mesg = "adding blog post failed!!!!!";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get category from its id
			Category category = session.get(Category.class, categoryId);
			// 4 . null checking
			if (category != null) {
				// => category : persistent
				// 5. Establish bi dir association between entities
				/*
				 * add a blog post ref in the List n set category ref to the post
				 */
				category.addBlogPost(newPost);
		//		session.persist(newPost); //still required since - no cascading still!!!!
			}

			tx.commit();
			mesg = "added new post , id=" + newPost.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String addNewBlog(BlogPost post, Long categoryId, Long bloggerId) {
		String mesg = "adding blog failed !!!!";
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			//3. Get category details from its id
			Category category=session.get(Category.class, categoryId);
			//4. Get blogger details from its id
			User blogger=session.get(User.class, bloggerId);
			//5 null checking
			if(category != null && blogger != null 
					&& blogger.getRole()==UserRole.BLOGGER) {
				//6. establish bi dir association Category 1<---->* BlogPost
				category.addBlogPost(post);
				//7. establish uni dir association User 1<-----* BlogPost 
				post.setBlogger(blogger);
	//			session.persist(post); NOT required since added cascading- save|udate|delete
			}
			tx.commit();//DML - insert with FKs
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String removeBlog(Long catId, Long blogId) {
		String mesg = "removing blog failed";

		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			//3. get categroy from its id
			Category category=session.get(Category.class, catId);
			//4. get blog from its id
			BlogPost post=session.get(BlogPost.class, blogId);
			//5 null checking
			if(category != null && post != null)
			{
				//category , post - persistent
				category.removeBlogPost(post);
				mesg="deleted blog post";
				
			}
			tx.commit();// DML - 
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

}
