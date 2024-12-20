package com.store.service;

import java.util.List;

import com.store.dto.ProductDTO;
import com.store.pojo.Product;

public interface ProductService {

	List<Product> getAllProducts();

	String addProduct(ProductDTO productDTO, Long id);

	String deleteProduct(Long productId);

}
