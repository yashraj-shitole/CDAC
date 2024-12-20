package com.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.dto.ApiResponse;
import com.users.dto.AuthRequest;
import com.users.dto.UserDTO;
import com.users.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
//	@Autowired //by constructor - spring reco way of D.I
	private final UserService userService;

	
	
	/*
	 * Desc - User signup 
	 * URL - http://host:port/users/signup
	 * Method - POST 
	 * payload - user reg dto 
	 * Successful Resp - SC 201, user details - all (dto) 
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 * 
	 */
	@PostMapping("/signup") //@RequestMapping(method=POST)
	public ResponseEntity<?> signUpUser(
			@RequestBody @Valid UserDTO dto) {
		System.out.println("in signup "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.signUp(dto));
		
	}		

	/*
	 * Desc - User signin 
	 * URL - http://host:port/users/signin 
	 * Method - POST 
	 * payload - dto (email n pwd) 
	 * Successful Resp - SC 200, user details - all (dto) 
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 * 
	 */
	@PostMapping("/signin") //@RequestMapping(method=POST)
	public ResponseEntity<?> signInUser(
			@RequestBody AuthRequest request) {
		//@RequestBody => Json -> Java (un marshalling | de ser)
		System.out.println("in signin " + request);
		try {
			return ResponseEntity.ok(
					userService.authenticateUser(request));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.
					status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	/*
	 * Desc - Get User details 
	 * URL - http://host:port/users/{userId} 
	 * Method - GET 
	 * 
	 * Successful Resp - SC 200, user details - all (dto) 
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 * 
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserDetails(@PathVariable Long userId)
	{
		return ResponseEntity.ok(userService.getUserDetails(userId));
	}
	/*
	 * Desc - Get User details along with the blogs
	 * URL - http://host:port/users/{userId}/blogs 
	 * Method - GET 
	 * 
	 * Successful Resp - SC 200, user details + List <BlogDTO>
	 * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 * 
	 */
	@GetMapping("/{userId}/blogs")
	public ResponseEntity<?> getUserDetailsWithBlogs(@PathVariable Long userId)
	{
		return ResponseEntity.ok(userService.getUserDetailsWithBlogs(userId));
	}
	
	

}
