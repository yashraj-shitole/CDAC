package com.app.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {
	@NotEmpty
	private String firstName;
	private String lastName;
	private String email;
	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Past
	private LocalDate dob;
	@Range(min = 0 , max=5000)
	private double regAmount;
	private UserRole role;

}
