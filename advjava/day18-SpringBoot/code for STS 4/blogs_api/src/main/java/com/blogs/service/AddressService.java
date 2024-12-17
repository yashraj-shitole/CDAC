package com.blogs.service;

import com.blogs.dto.AddressDTO;
import com.blogs.dto.ApiResponse;

public interface AddressService {
//add a method to link user address
	ApiResponse assignAddress(AddressDTO dto,Long userId);
}
