package com.store.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.UserDao;
import com.store.dto.UserDTO;import com.store.pojo.User;

@Service
@Transactional
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public String addUser(UserDTO userDto) {
		
		User user= modelMapper.map(userDto, User.class);
		if (user!=null) {		
			user.setRole("user");
			userDao.save(user);
			return "user added";
		}
		
		return "user not added";
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> users=userDao.findAll();

				for (User user : users) {
					user.getOrders().size();
				}
				
				
		
		return users;
	}
	
	

}
