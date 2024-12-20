package com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.pojo.User;

public interface UserDao extends JpaRepository<User, Long> {

}
