package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.pojo.User;
import com.company.pojo.Vehical;

public interface VehicalDao extends JpaRepository<Vehical, Long> {

	Vehical findByUser(User user);

}
