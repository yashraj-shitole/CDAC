package com.store.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.OrderDao;
import com.store.dao.ProductDao;
import com.store.dao.UserDao;
import com.store.dto.OrderReqDTO;
import com.store.pojo.Order;
import com.store.pojo.Product;
import com.store.pojo.User;

@Service
@Transactional
public class OrderServiceImp implements OrderService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	

	@Override
	public String addOrder(OrderReqDTO entity) {
		
			System.out.println(entity.getUserId()+" "+entity.getProductId());
		
			if (entity.getProductId() !=null && entity.getUserId() != null) {
				
		Optional<User> user=userDao.findById(entity.getUserId());
		
		Optional<Product> product=productDao.findById(entity.getProductId());
		
		
		if (entity.getQuantity() > product.get().getAvailableQuantity()) {
			return "No sufficient quantity, available quantity is "+product;
		}
		
		if (user.get()!=null && product.get()!=null) {
			
			
			
			Order order=new Order(entity.getQuantity(), user.get(), product.get());
			product.get().setAvailableQuantity(product.get().getAvailableQuantity()-entity.getQuantity());
			
			orderDao.save(order);
			
			return "Order placed with id "+order.getId();
			
		}
			}
		
		
		
		return "wrong details";
	}


	@Override
	public List<Order> getAllOrders() {
		
		
		return orderDao.findAll();
	}


	@Override
	public List<Order> getOrdersByDate(LocalDateTime from, LocalDateTime to) {
		
		
		List<Order> orders=orderDao.getOrderByDate(from, to);
		

		
		return orders;
	}

	
}
