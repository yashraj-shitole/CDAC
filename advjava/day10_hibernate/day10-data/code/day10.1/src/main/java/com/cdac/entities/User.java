package com.cdac.entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity //mandatory cls level annoatation
@Table(name = "new_users") //to customize table name
public class User {
	//id prop MUST be -  Serializable
	@Id // PK
	 //For auto ID generation using auto increment constraint - 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id") //column name - user_id
	private Long userId; // mapped to PK
	@Column(length = 20, name="first_name")//varchar(20)
	private String firstName;
	@Column(length = 20, name="last_name")//varchar(20)
	private String lastName;
	@Column(length = 25,unique = true)//varchar(25) , unique constraint
	private String email;
	@Column(length = 20,nullable = false)//NOT NULL constraint
	private String password;
	@Transient //skipped from col generation
	private String confirmPassword;
	private LocalDate dob;//column type - date
	@Enumerated(EnumType.STRING)  //varchar
	@Column(length = 20) //column rol , varchar(20)
	private UserRole role;
	@Column(name="reg_amount")
	private double regAmount;
	@Lob //large object , col type - longblob
	private byte[] image;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
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
	//add overloaded ctor to test ctor expression	
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	//all getters n setters
	public Long getUserId() {
		return userId;
	}
	

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", role=" + role + ", regAmount=" + regAmount + "]";
	}
	

}
