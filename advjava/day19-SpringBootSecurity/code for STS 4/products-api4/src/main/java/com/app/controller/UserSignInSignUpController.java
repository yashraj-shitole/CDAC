package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.dto.UserDTO;
import com.app.dto.UserRespDTO;
import com.app.security.JwtUtils;
import com.app.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserSignInSignUpController {
	// depcy for user's sign up
	@Autowired
	private UserService userService;
	// depcy for user's sign in
	@Autowired
	private AuthenticationManager authenticationManager;
	// depcy Jwt Utils
	@Autowired
	private JwtUtils jwtUtils;

	/*
	 * Desc - User registration(sign up) URL - http://host:port/users/signup Method
	 * - POST Payload - UserDTO err resp - ApiResp - err mesg success resp - UserDTO
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody @Valid UserDTO dto) {
		System.out.println("in user sign up");
		UserDTO resp = userService.signupUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}

	/*
	 * Desc - user sign in URL - http://host:port/users/signin Method - POST (for
	 * security + JWT creation) payload - DTO (email , pwd) success resp - dto -
	 * mesg + JWT resp - api resp - err mesg
	 * 
	 */
	@PostMapping("/signin")
	@Operation(description = "User Sign In")
	public ResponseEntity<?> userSignIn(@RequestBody @Valid AuthRequest dto) {
		System.out.println("in user sign in " + dto);
//For user authentication , simply call authenticate(...) method 
		// of the Spring sec supplied AuthMgr.
		/*
		 * API of AuthenticationManager - Authentication authenticate(Authentication
		 * token) throws AuthenticationException Authentication - i.f imple class -
		 * UserNamePasswordAuthenticationToken(Object email,Object password) ...
		 */
		Authentication successfulAuth = authenticationManager
				.authenticate
				(new UsernamePasswordAuthenticationToken
						(dto.getEmail(), dto.getPasswrd()));
		System.out.println(successfulAuth.isAuthenticated() 
				+ " " + successfulAuth.getAuthorities() + " "
				+ successfulAuth.getPrincipal());
		/*
		 * In case of successful auth - send signed JWT in resp DTO to the clnt
		 */
		String jwt = jwtUtils.generateJwtToken(successfulAuth);
		return ResponseEntity.
				status(HttpStatus.CREATED)
				.body(new UserRespDTO("Successful Authentication", jwt));

	}

}
