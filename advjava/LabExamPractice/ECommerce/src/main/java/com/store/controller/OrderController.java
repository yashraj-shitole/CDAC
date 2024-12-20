package com.store.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.OrderReqDTO;
import com.store.pojo.Order;
import com.store.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	
	
	@GetMapping("/")
	public ResponseEntity<?> getMethodName() {
		
		List<Order> orders=orderService.getAllOrders();
		
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/{from}/{to}")
	public ResponseEntity<?> getMethodName(@PathVariable LocalDate from, @PathVariable LocalDate to) {
		
		LocalDateTime fromDate = from.atStartOfDay();
		LocalDateTime toDate=to.atStartOfDay();
//		orderService.getOrdersByDate(fromDate,toDate);
		
		return ResponseEntity.ok(orderService.getOrdersByDate(fromDate,toDate));
	}
	
	
	
	
	@PostMapping("/")
	public ResponseEntity<?> orderProduct(@RequestBody OrderReqDTO entity) {

		System.out.println(entity.toString());

		
		String message=orderService.addOrder(entity);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
	}
	
	
}
