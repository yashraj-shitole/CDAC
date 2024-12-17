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
/*
 * Configure a bean to store user details
 */
	@Bean
	public UserDetailsService userDetailsService() {
		//User(String userName, String pwd,
		//Collection<? extends GrantedAuthority> authorities)
		//GrantedAuthority i/f - implemented by SimpleGrantedAuthrity(String roleName)
		//MUST start with ROLE_
		User admin=new User("Rama Patil",
				passwordEncoder.encode("123456"),
				List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
		User customer=new User("Mihir Kelkar",
				passwordEncoder.encode("3456"),
				List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER")));
		return new InMemoryUserDetailsManager(admin,customer);
	}
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
