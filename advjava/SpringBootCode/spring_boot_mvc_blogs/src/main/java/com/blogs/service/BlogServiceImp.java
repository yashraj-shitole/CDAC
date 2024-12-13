package com.blogs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.BlogDao;
import com.blogs.dao.CategoryDao;
import com.blogs.pojos.BlogPost;
import com.blogs.pojos.Category;


@Service
@Transactional
public class BlogServiceImp implements BlogsService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
		
	@Override
	public boolean addBlog(String title, String content, String description, Long categoryId) {
		
		Category category=categoryDao.getOne(categoryId);
		
		System.out.println(category);
		
		BlogPost blogpost=new BlogPost(title, description, content ,category);
		
		category.getBlogPosts().add(blogpost);
		
		categoryDao.save(category);
		
		System.out.println("INSIDE ADD BLOG");
		
		blogDao.save(blogpost);
		
		return true;
	}

}
