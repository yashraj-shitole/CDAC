package com.store.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEnitity{
	
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 200)
	private String discription;

	@Column(name = "available_quantity")
	private int availableQuantity;
	
	private double price;
	
	@Column(name = "product_status")
	private boolean productStatus;
	
}
