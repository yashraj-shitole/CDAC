package com.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = { "password" })
@AllArgsConstructor
public class UserEntity extends BaseEntity {

	@Column(name = "first_name", length = 20) // column name , varchar(20)
	private String firstName;
	@Column(name = "last_name", length = 20) // column name , varchar(20)
	private String lastName;
	@Column(length = 25, unique = true) // adds unique constraint
	private String email;
	@Column(length = 500, nullable = false) // not null constraint
	private String password;
	private LocalDate dob;
	@Column(name = "reg_amount")
	private double regAmount;
	@Enumerated(EnumType.STRING) // create column of type
	// varchar to store the name of constant
	@Column(length = 30) // varchar(30)
	private UserRole role;

}
