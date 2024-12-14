package com.blogs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.custom_exceptions.AuthenticationException;
import com.blogs.dao.UserDao;
import com.blogs.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// depcy
	@Autowired
	private UserDao userDao;

	@Override
	public User authenticateUser(String em, String pass) {
//		Optional<User> optional = userDao.findByEmailAndPassword(em, pass);
//		if(optional.isPresent())
//			return optional.get();
		return userDao.findByEmailAndPassword(em, pass)
				.orElseThrow(() 
						-> new AuthenticationException("Invalid Email or Password!!!!!"));
	}  
	/*
	 * valid login - returns DETACHED user to the caller 
	 * invalid login - throws AuthenticationException - err mesg
	 */

}
