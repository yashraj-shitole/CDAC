package com.blogs.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.UserDao;
import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User authenticateUser(String email, String password) {
		
//		Optional<User> byEmailAndPassword = userDao.findByEmailAndPassword(email, password);
//		
//		if (byEmailAndPassword.isPresent()) {
//			return byEmailAndPassword.get();
//		}
//		.orElseThrow() performs above logic
		return userDao.findByEmailAndPassword(email, password).orElseThrow();
	}

	/*
	 * valid login- returns user to caller
	 * invalid login- throws NoSuchElementException
	 */

	@Override
	public User register(String email, String firstName, String lastName, String address, LocalDate dob, double amount,
			String password) {
		
		User user= new User(firstName, lastName, email, password, dob, amount, UserRole.BLOGGER);
		
		userDao.save(user);
		
		
		return user;
	}
	
	
}
