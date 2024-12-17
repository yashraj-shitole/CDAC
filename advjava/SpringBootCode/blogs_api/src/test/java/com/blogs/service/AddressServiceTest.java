package com.blogs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.net.ResponseCache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.AddressDTO;
import com.blogs.dto.ApiResponse;

@SpringBootTest
class AddressServiceTest {

	@Autowired
	private AddressService addressService;
	
	
	@Test
	void testAssignAddress() {
		
		AddressDTO addressDto=new AddressDTO("majrwadi Road", "Malbhag", "Kurundwad", "Maharashtra", "India", "416106");
		
		ApiResponse resp= addressService.assignAddress(addressDto, 2l);
		
		
		assertEquals(true, resp.getMessage().contains("Assigned") );
	}

	
}
