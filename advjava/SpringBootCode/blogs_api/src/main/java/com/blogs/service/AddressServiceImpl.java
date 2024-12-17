package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dao.AddressDao;
import com.blogs.dao.UserDao;
import com.blogs.dto.AddressDTO;
import com.blogs.dto.ApiResponse;
import com.blogs.pojos.Address;
import com.blogs.pojos.User;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse assignAddress(AddressDTO dto, Long userId) {
		// 1. get user (persistent) from its id
		User user = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!"));
		// 2. map dto -> entity
		Address address = modelMapper.map(dto, Address.class);
		// 3. establish association User 1--->1 Address
		user.setUserAddress(address);
		// 4. save explicitly - since no cascading chosen !
		Address persistentAdr = addressDao.save(address);
		return new ApiResponse("Assigned user adr with ID=" + persistentAdr.getId());
	}

}
