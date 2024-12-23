package com.company.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.UserDao;
import com.company.dto.ApiResponse;
import com.company.dto.UserDTO;
import com.company.pojo.User;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;

	
	
	@Override
	public ApiResponse addUser(UserDTO userDto) {
		
		System.out.println(userDto);
		User user=modelMapper.map(userDto, User.class);
		
		System.out.println(user);
		
		userDao.save(user);
		
		return new ApiResponse(LocalDateTime.now(), "User created successfully with user id "+user.getId()) ;
	}
	
	
	
	
}
