package com.blogs.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.blogs.dto.UserDTO;

@FeignClient(name="User-Service")
//@FeignClient(url="http://localhost:8080/users",value="UserService")
public interface UserServiceClient {

	@GetMapping("/users/{userId}")
	UserDTO getUserDetailsById(@PathVariable Long userId);

}
