package com.sunbeam.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class EmployeeRespDto extends BaseDTO {
	
	
	private String firstName;
	private String lastName;
	
	private String email;
	
	private String location;
	
	private String department;
	
	private LocalDate joinDate;
	
	private double salary;
	

}
