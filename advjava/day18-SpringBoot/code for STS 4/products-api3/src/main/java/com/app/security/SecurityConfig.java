package com.app.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//depcy - password encoder
	@Autowired
	private PasswordEncoder passwordEncoder;
	// Configure the bean to customize spring security filter chain
		@Bean
		public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception
		{
			http.csrf(customizer -> customizer.disable())
	        .authorizeHttpRequests
	        (request -> 
	        request.requestMatchers("/products/view",
	        		"/users/signup","/users/signin",
					"/v*/api-doc*/**","/swagger-ui/**").permitAll()
	        	
	       .requestMatchers("/products/purchase/**").hasRole("CUSTOMER")
	       .requestMatchers("/products/add","/products/delete")
	       .hasRole("ADMIN")        		
	        .anyRequest().authenticated())  
	        .httpBasic(Customizer.withDefaults())
	        .sessionManagement(session 
	        		-> session.sessionCreationPolicy(
	        				SessionCreationPolicy.STATELESS));
	        return http.build();
		}
}
