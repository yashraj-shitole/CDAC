package com.store.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.store.dto.OrderReqDTO;
import com.store.pojo.Order;

public interface OrderService {

	String addOrder(OrderReqDTO entity);

	List<Order> getAllOrders();


	List<Order> getOrdersByDate(LocalDateTime from, LocalDateTime to);

}
