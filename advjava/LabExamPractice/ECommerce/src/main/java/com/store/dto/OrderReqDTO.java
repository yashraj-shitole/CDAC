package com.store.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderReqDTO extends BaseDTO{

	
	private  int quantity;
	
	private Long userId;
	
	private Long productId;
	
}
