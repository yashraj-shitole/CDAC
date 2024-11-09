package com.sunbeam.daos;

import java.util.*;
import com.sunbeam.entities.User;

public interface UserDao extends AutoCloseable {

	ArrayList<User> findAllUsers() throws Exception; 
	User findUserById(int id) throws Exception;
	int saveUser(User u) throws Exception;
	int updateUser(User u) throws Exception;
	int deleteUserById(int id) throws Exception;
	User findUserByEmail(String email) throws Exception;
	
}
