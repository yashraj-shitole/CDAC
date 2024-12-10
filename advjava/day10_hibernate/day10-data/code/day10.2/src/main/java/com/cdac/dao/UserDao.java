package com.cdac.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.cdac.entities.User;
import com.cdac.entities.UserRole;

public interface UserDao {
//add a method to register new user
	String signUpUser(User user);
	//add a method to get user details by id
	User getUserDetails(Long userid);
	//get all users details
	List<User> getAllUsers();
	List<User> getSelectedUsers(UserRole userRole, LocalDate dob);
	List<String> getLastNames(UserRole role);
	List<User> getSelectedUsersByRole(UserRole valueOf);
	String changePassword(String email, String oldPwd, String newPwd);
	String deleteUserDetails(Long userId);
	String applyDiscount(LocalDate date, double discount);
	String saveImage(String fileName, Long userId) throws IOException;
	String restoreImage(String fileName, String email) throws IOException;
}
