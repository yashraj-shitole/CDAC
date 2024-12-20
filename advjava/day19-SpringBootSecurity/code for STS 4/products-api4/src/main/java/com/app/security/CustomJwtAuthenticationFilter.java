package com.app.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // configuring it as a spring bean so that it can be
//injected as a depcy in any other spring bean
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// check Authorization header
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
//extract JWT
			String jwt = authHeader.substring(7);
			// validate JWT n in case of success create Authentication from it.
			Authentication authentication = 
					jwtUtils.populateAuthenticationTokenFromJWT(jwt);
			System.out.println(authentication+" "+authentication.getPrincipal());
			//in case of no exception , save fully authenticated details(w/o password)
			//under spring sec ctx holder
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		// for continuing control to the next filter in the chain
		filterChain.doFilter(request, response);

	}

}
