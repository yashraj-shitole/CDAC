package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.AddressDTO;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.AuthRequest;
import com.blogs.service.AddressService;
import com.blogs.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	// depcy
	@Autowired
	private UserService userService;
	// depcy
	@Autowired
	private AddressService addressService;

	/*
	 * Desc - user sign in URL - http://host:port/users/signin Method - POST (for
	 * security) payload - DTO (email , pwd) success resp - user details - dto err
	 * resp - api resp - err mesg
	 * 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody 
			@Valid AuthRequest dto) {
		System.out.println("in user sign in " + dto);

		return ResponseEntity.ok(userService.signIn(dto));

	}

	/*
	 * Desc - Assign address to the user URL -
	 * http://host:port/users/{userId}/address Method - POST (for creating address
	 * resource) payload - DTO (adr details) success resp - api resp - mesg err resp
	 * - api resp - err mesg
	 * 
	 */
	@PostMapping("/{userId}/address")
	public ResponseEntity<?> assignUserAddress(@RequestBody AddressDTO dto, @PathVariable Long userId) {
		System.out.println("in assign adr " + dto + " " + userId);

		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.assignAddress(dto, userId));

	}

}
