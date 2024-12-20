package com.store.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.pojo.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

	@Query("select o from Order o where o.createdOn >= :from AND o.createdOn <= :to")
	List<Order> getOrderByDate(LocalDateTime from, LocalDateTime to);

}
