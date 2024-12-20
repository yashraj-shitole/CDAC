package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressDTO {
	@NotBlank
	private String adrLine1;
	
	private String adrLine2;
	@NotBlank
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
	
		
}
