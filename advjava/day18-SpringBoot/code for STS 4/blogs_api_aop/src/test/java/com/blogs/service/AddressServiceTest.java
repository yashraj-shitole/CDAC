package com.blogs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.AddressDTO;
import com.blogs.dto.ApiResponse;

@SpringBootTest //To tell Spring boot test container to scan all spring beans 
//Controller , Service , DAO n entities
class AddressServiceTest {
	//depcy
	@Autowired
	private AddressService addressService;

	@Test
	void testAssignAddress() {
		AddressDTO dto=new AddressDTO("line12", "line22", "Pune", "MH",
				"India", "411007");
		ApiResponse resp = addressService.assignAddress(dto, 2l);
		assertEquals(true,resp.getMessage().contains("Assigned"));		
	}

}
