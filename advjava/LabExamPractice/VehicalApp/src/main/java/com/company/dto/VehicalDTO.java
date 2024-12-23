package com.company.dto;

import java.time.LocalDate;

import com.company.pojo.Company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicalDTO {

	
	@NotBlank
	private Long userId;
	
	@NotBlank	private String vehicalName;
	
	@NotBlank	private Company company;
	
	@NotBlank	private String vehicalNumber;
	
	@NotBlank	private String vehicalType;
	

	private LocalDate purchaseDate;
	
	
}
