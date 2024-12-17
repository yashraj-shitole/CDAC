package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.UserDTO;
import com.app.entities.UserEntity;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserEntityRepository userEntityRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDTO signupUser(UserDTO dto) {
		//1. map DTO -> entity
		UserEntity user=modelMapper.map(dto, UserEntity.class);
		//2. encode password
		user.setPassword(encoder.encode(user.getPassword()));
		//3. save
		UserEntity persistentUser = userEntityRepository.save(user);
		return modelMapper.map(persistentUser, UserDTO.class);
	}

}
