package com.cdac.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // mandatory cls level annoatation
@Table(name = "users") // to customize table name
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,
exclude = {"password","confirmPassword","image"})
public class User extends BaseEntity{
	
	@Column(length = 20, name = "first_name") // varchar(20)
	private String firstName;
	@Column(length = 20, name = "last_name") // varchar(20)
	private String lastName;
	@Column(length = 25, unique = true) // varchar(25) , unique constraint
	private String email;
	@Column(length = 20, nullable = false) // NOT NULL constraint
	private String password;
	@Transient // skipped from col generation
	private String confirmPassword;
	private LocalDate dob;// column type - date
	@Enumerated(EnumType.STRING) // varchar
	@Column(length = 20) // column rol , varchar(20)
	private UserRole role;
	@Column(name = "reg_amount")
	private double regAmount;
	@Lob // large object , col type - longblob
	private byte[] image;

	public User(String firstName, String lastName, String email, String password, String confirmPassword, LocalDate dob,
			UserRole role, double regAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dob = dob;
		this.role = role;
		this.regAmount = regAmount;
	}

	// add overloaded ctor to test ctor expression
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
}
