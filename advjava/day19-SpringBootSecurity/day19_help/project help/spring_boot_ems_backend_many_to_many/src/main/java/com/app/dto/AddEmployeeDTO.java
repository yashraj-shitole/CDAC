package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.EmpType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AddEmployeeDTO {
	@JsonProperty(access = Access.READ_ONLY) // matches with emp id , it will be used during serialization
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Email
	private String email;
	private String password;
	private String confirmPassword;
	private LocalDate joinDate;
	private EmpType type;
	private double salary;
	private Long deptId;// Note this : name of the DTO prop is deptId , using it in emp service layer to
						// get dept details
}
