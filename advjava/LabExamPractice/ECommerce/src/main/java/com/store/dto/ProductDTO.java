package com.store.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private String name;
	
	private String discription;

	private int availableQuantity;
	
	private double price;
	
	private boolean productStatus;
}
