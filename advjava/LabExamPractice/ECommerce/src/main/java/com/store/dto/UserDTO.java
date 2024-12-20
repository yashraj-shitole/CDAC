package com.store.dto;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private String name;
	private String password;
	private String email;
	private LocalDate dob;
//	private List<Order> orders;
//	private Address address;
	
}
