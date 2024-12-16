package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ApiException;
import com.blogs.dao.UserDao;
import com.blogs.dto.AuthRequest;
import com.blogs.dto.UserRespDTO;
import com.blogs.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserRespDTO signIn(AuthRequest dto) {
		// 1. invoke dao's method
		User userEntity = userDao.
				findByEmailAndPassword(dto.getEmail(), dto.getPasswrd())
				.orElseThrow(() -> 
				new ApiException("Invalid Email or password !!!!!"));
		//user entity : persistent -> dto
		return modelMapper.map(userEntity, UserRespDTO.class);
	}

}
