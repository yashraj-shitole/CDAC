package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.pojo.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUserName(String username);

}
