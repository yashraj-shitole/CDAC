package com.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.pojo.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	
	List<Product> findByProductStatusTrue();

}
