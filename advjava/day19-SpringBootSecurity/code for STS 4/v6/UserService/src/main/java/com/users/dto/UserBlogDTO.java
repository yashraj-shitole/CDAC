package com.users.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.users.entities.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBlogDTO extends BaseDTO{
	@NotBlank
	private String firstName;
	private String lastName;
	private String email;	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	private LocalDate dob;
	private double regAmount;
	private Role role;
	private List<BlogPostRespDTO> blogs;
}
