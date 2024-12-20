package com.app.service;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;

public interface AddressService {
	// assign emp address

//get address details
	AddressDTO getAddressDetails(long addressId);

//Instead of sending a mesg , If you want to send address in a resp , change ret type to AddressDTO
	ApiResponse assignEmpAddress( Long empId, @Valid AddressDTO address);

	ApiResponse updateEmpAddress( Long empId, @Valid AddressDTO address);

	AddressDTO patchEmpAddress( Long empId, Map<String, Object> map);

	ApiResponse deleteAddressDetails(Long empId);
}
