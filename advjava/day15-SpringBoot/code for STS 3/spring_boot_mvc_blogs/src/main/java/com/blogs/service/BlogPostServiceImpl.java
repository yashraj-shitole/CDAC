package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dao.BlogPostDao;
import com.blogs.pojos.BlogPost;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {
	// depcy - dao
	@Autowired // field level D.I
	private BlogPostDao blogPostDao;

	@Override
	public List<BlogPost> getAvailablePosts() {
		// TODO Auto-generated method stub
		return blogPostDao.findByStatusTrue();
	}

	@Override
	public String deleteBlogPost(Long postId) {
		// 1. get blog post by its id
		BlogPost post = blogPostDao.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid post id !!!!!"));
		//post : Pesistent
		post.setStatus(false);
		return "Soft Deleted blog post !" ;
	}//tx.commit() -> session.flush() -> DML -update -> session.close()

}
