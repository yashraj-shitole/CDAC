package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.blogs.custom_exceptions.ApiException;
import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dao.BlogPostDao;
import com.blogs.dao.CategoryDao;
import com.blogs.dao.UserDao;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostDTO;
import com.blogs.pojos.BlogPost;
import com.blogs.pojos.Category;
import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {
	//depcy - dao
	@Autowired 
	private BlogPostDao blogPostDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addBlogPost(BlogPostDTO dto) {
		// 1. get category by it's id
		Category category=categoryDao.
				findById(dto.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id!!!!"));
		
		//2. get blogger by its id
		User blogger=userDao.findById(dto.getBloggerId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid blogger id!!!!"));

		//3. confirm role
		if(blogger.getRole()==UserRole.BLOGGER) {
			//4. map dto -> entity
			BlogPost entity=mapper.map(dto, BlogPost.class);			
			//5. Establish association Category1 <----->* BlogPost
			category.addBlogPost(entity);
			//6. Establish association User(blogger) 1<-----* BlogPost
			entity.setBlogger(blogger);
			//7. set status
			entity.setStatus(true);
		//	blogPostDao.save(entity);
			return new ApiResponse("Blogpost added ");
		}
		
		throw new ApiException("You must be logged in as blogger to add a post !!!!");
	}

}
