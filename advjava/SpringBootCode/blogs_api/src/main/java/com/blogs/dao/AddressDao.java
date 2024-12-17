package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Address;

public interface AddressDao extends JpaRepository<Address,Long> {

}
