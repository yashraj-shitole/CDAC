package com.users.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.entities.User;

public interface UserDao extends JpaRepository<User,Long>{
//add derived finder method for user signin 
	Optional<User> findByEmailAndPassword(String email,String pass);
}
