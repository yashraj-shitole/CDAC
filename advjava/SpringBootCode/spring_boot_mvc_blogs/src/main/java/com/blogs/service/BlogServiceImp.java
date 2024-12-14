package com.blogs.service;


import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.BlogDao;
import com.blogs.dao.CategoryDao;
import com.blogs.dao.UserDao;
import com.blogs.pojos.BlogPost;
import com.blogs.pojos.Category;
import com.blogs.pojos.User;


@Service
@Transactional
public class BlogServiceImp implements BlogsService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
    private HttpSession session;
	
	@Autowired
	private UserDao userdao;
		
	@Override
	public boolean addBlog(String title, String content, String description, Long categoryId, Long userId) {
		
		Category category=categoryDao.getOne(categoryId);
		
		System.out.println(title+content+description+categoryId);
		System.out.println(category);
		
		
		User user = userdao.getOne(userId);
		
		System.out.println(user);
		
		
		BlogPost blogpost=new BlogPost(title, description, content ,category, user);
		
		System.out.println(blogpost);		
		
		category.getBlogPosts().add(blogpost);
		
		categoryDao.save(category);
		
		System.out.println("INSIDE ADD BLOG");
		
		blogDao.save(blogpost);
	return true;
	}

}
