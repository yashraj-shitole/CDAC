package com.company.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.UserDao;
import com.company.dao.VehicalDao;
import com.company.dto.ApiResponse;
import com.company.dto.VehicalDTO;
import com.company.pojo.User;
import com.company.pojo.Vehical;

import jakarta.persistence.Id;


@Service
@Transactional
public class VehicalServiceImp implements VehicalService {
	
	@Autowired
	private VehicalDao vehicalDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse addVehical(VehicalDTO entity) {
		
		Optional<User> user=userDao.findById(entity.getUserId());
		
		if (user.isEmpty()) {
			return new ApiResponse(LocalDateTime.now(), "user not present");
		}
		
		
		Vehical vehical= modelMapper.map(entity, Vehical.class);
		
		vehical.setUser(user.get());
		
		vehicalDao.save(vehical);
		
		
		return new ApiResponse(LocalDateTime.now(), "Vehical added with vehical id "+vehical.getId()+" for user "+user.get().getUserName());
	}

	@Override
	public ApiResponse deleteVehical(String username) {

		User user=userDao.findByUserName(username);
		
		if (user == null) {
			return new ApiResponse(LocalDateTime.now(),"User not present");
		}
		
		
		List<Vehical> v=vehicalDao.findAll();
		
		for(Vehical vehical:v) {
			
			if (vehical.getUser().getUserName().equals(username)) {
				vehicalDao.delete(vehical);
			}
		}
		
		return new ApiResponse(LocalDateTime.now(), "Vehical deleted");
	}
	
	

	@Override
	public List<RespUserDto> getUserByDate(LocalDate date) {
		
		List<Vehical> vehicals= vehicalDao.findAll();
		
		List<RespUserDto> respUserDto=new ArrayList<>();
		
		for(Vehical v:vehicals) {
			
			if (v.getPurchaseDate().equals(date)) {
				
				RespUserDto r=new RespUserDto(v.getUser().getUserName(), v.getVehicalName());
				
				respUserDto.add(r);
			}
			
		}
		
		
		return respUserDto;
	}
	
	
	

}
