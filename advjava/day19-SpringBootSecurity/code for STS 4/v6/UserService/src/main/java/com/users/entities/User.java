package com.users.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class User extends BaseEntity {
	@Column(name = "first_name", length = 25) // col name , varchar(25)
	private String firstName;
	@Column(name = "last_name", length = 25) // col name , varchar(25)
	private String lastName;
	@Column(length = 20, unique = true) // varchar(20), unique constraint
	private String email;
	@Column(length = 25, nullable = false) // NOT NULL
	private String password;
	private LocalDate dob;
	@Column(name = "reg_amount")
	private double regAmount;
	@Enumerated(EnumType.STRING) // col type : varchar
	@Column(length = 20)
	private Role role;
	@Lob // => large object , col type : longblob
	private byte[] image;
	// User 1-->1 Address , example of uni dir one-one association between the
	// entities
	// one , child , owning
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address userAddress;

	// user registration
	public User(String firstName, String lastName, String email, String password, LocalDate dob, double regAmount,
			Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.regAmount = regAmount;
		this.role = role;
	}

	// add overloaded ctor for ctor expression
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

}
