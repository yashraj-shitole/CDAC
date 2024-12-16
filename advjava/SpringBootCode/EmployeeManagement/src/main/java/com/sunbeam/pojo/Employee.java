package com.sunbeam.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "employee")
public class Employee extends BaseEntity{

	@Column(length = 100,name = "first_name")
	private String firstName;
	@Column(length = 100,name = "last_name")
	private String lastName;
	
	@Column(length = 100,name = "email")
	private String email;
	
	@Column(length = 50,name = "location")
	private String location;
	
	@Column(length = 20,name = "department")
	private String department;
	
	@Column(name = "join_date")
	private LocalDate joinDate;
	
	@Column(name = "salary")
	private double salary;
	
}
