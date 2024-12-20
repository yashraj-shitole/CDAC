package com.blogs.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDTO extends BaseDTO{
	@NotBlank
	private String firstName;
	private String lastName;
	private String email;	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	private LocalDate dob;
	private double regAmount;
	private Role role;
}
