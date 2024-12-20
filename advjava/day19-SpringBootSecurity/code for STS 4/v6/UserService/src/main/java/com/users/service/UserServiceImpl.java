package com.users.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.users.custom_exceptions.AuthenticationException;
import com.users.custom_exceptions.ResourceNotFoundException;
import com.users.dao.UserDao;
import com.users.dto.AuthRequest;
import com.users.dto.BlogPostRespDTO;
import com.users.dto.UserDTO;
import com.users.entities.User;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	// depcy
//	@Autowired
	private UserDao userDao;
//	@Autowired
	private ModelMapper mapper;
	private BlogCategoryServiceClient blogCategoryServiceClient;

	@Override
	public UserDTO authenticateUser(AuthRequest dto) {
		// 1.invoke dao 's method
		User user = userDao.findByEmailAndPassword(dto.getEmail(), dto.getPwd())
				.orElseThrow(() -> new AuthenticationException("Invalid Email or Password !!!!!!"));
		// valid login -user : persistent -> entity -> dto
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO signUp(@Valid UserDTO dto) {
		User user = userDao.save(mapper.map(dto, User.class));
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO getUserDetails(Long userId) {
		// TODO Auto-generated method stub
		User user = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID!!!!"));
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO getUserDetailsWithBlogs(Long userId) {
		UserDTO user=getUserDetails(userId);
		/*
		 * Make REST API call to blog-category service 
		 */
		List<BlogPostRespDTO> blogs = blogCategoryServiceClient.getPostByAuthor(userId);
		user.setBlogs(blogs);
		return user;		
	}
	

}
