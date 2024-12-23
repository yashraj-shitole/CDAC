package com.company.service;

import com.company.dto.ApiResponse;
import com.company.dto.UserDTO;

public interface UserService {

	ApiResponse addUser(UserDTO user);

}
