package com.store.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.ProductDao;
import com.store.dao.UserDao;
import com.store.dto.ProductDTO;
import com.store.pojo.Product;
import com.store.pojo.User;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMaper;
	
	@Override
	public List<Product> getAllProducts() {
		
		List<Product> products=productDao.findByProductStatusTrue();
		
		
		return products;
	}
	

	@Override
	public String addProduct(ProductDTO productDTO,Long id) {
		
		Optional<User> userOptional=userDao.findById(id);
		
		User user=userOptional.get();
		
		if (user!=null && user.getRole().equals("admin")) {
			
			Product product=modelMaper.map(productDTO, Product.class);
			
		
			if (product!=null) {
				
				productDao.save(product);
				return "Product added";
				
			}
			else {
				return "Null product passed";
			}
			
		}
		else {
			return "Not a admin";
		}
	}

	@Override
	public String deleteProduct(Long productId) {
		
		Optional<Product> product= productDao.findById(productId);
		
		if (product.isEmpty()) {
			return "product with id "+productId+" is not present";
		}
		else {
			product.get().setProductStatus(false);
			productDao.save(product.get());
			return  product.get().getName()+" deleted";
		}
		
	}

}
