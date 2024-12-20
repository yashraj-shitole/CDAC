package com.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.ProductDTO;
import com.store.pojo.Product;
import com.store.service.ProductService;

import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping("/")
	public ResponseEntity<?> MethodName() {
		
		List<Product> products= productService.getAllProducts();
		
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> postMethodName(@RequestBody ProductDTO productDTO, @PathVariable Long userId) {

		String message=productService.addProduct(productDTO,userId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
		
		
		String message=productService.deleteProduct(productId);
		
		
		return ResponseEntity.ok(message);
		
	}
	
	
	
}
