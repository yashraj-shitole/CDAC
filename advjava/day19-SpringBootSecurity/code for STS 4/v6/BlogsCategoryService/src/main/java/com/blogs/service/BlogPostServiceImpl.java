package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dao.BlogPostDao;
import com.blogs.dao.CategoryDao;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostReqDTO;
import com.blogs.dto.BlogPostRespDTO;
import com.blogs.dto.UserDTO;
import com.blogs.entities.BlogPost;
import com.blogs.entities.Category;

import feign.FeignException;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {
	// depcy
//	@Autowired
	private final BlogPostDao blogPostDao;
//	@Autowired
	private final ModelMapper mapper;

//	@Autowired
	private final CategoryDao categoryDao;

	private final UserServiceClient userServiceClient;

	@Override
	public ApiResponse postNewBlog(BlogPostReqDTO requestDTO) {
		// 1. get category from it's id
		Category category = categoryDao.findById(requestDTO.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
		try {
			// To Do add a micro service call here - to validate if user id is valid or not
			// !
			UserDTO userDetail = userServiceClient.getUserDetailsById(requestDTO.getBloggerId());
			System.out.println("user details via open feign client call " + userDetail);

			BlogPost blogPost = mapper.map(requestDTO, BlogPost.class);
			// 2. category 1<--->* post (establish bi dir asso)
			category.addBlogPost(blogPost);
			// 3. UserService (Blogger service) is another microservice
			blogPost.setBloggerId(requestDTO.getBloggerId());
			// 4. save blog post
			BlogPost periststentBlog = blogPostDao.save(blogPost);
			return new ApiResponse("New Blog added with ID=" + periststentBlog.getId());
		} catch (FeignException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			return new ApiResponse("Adding new blog failed "+e.getMessage());
		}
	}

	@Override
	public List<BlogPostRespDTO> getPostByAuthor(Long bloggerId) {
		// TODO Auto-generated method stub
		return blogPostDao.findByBloggerId(bloggerId).stream().map(blog -> mapper.map(blog, BlogPostRespDTO.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<BlogPostRespDTO> getAllPosts() {
		// TODO Auto-generated method stub
		return blogPostDao.findAll().stream()
				.map(blog -> mapper.map(blog, BlogPostRespDTO.class))
				.collect(Collectors.toList());
	}

}
