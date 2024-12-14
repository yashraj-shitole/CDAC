package com.blogs.service;

import com.blogs.pojos.User;

public interface UserService {
	User authenticateUser(String em, String pass);
}
