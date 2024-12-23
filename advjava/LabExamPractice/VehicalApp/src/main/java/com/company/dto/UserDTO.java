package com.company.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

	@NotBlank
	private String userName;
	
	@Email(message = "email not valid")
	private String email;
	
	@NotBlank
	private String password;

	@NotBlank
	private String city;
	
	@Size(min = 9,max = 10, message = "number not valid")
	private String contactNumber;
		
	private LocalDate birthDate;
	
}
