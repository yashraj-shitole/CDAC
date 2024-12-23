package com.company.pojo;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "users")
public class User extends Base{
	
//	1) Uid (unique identifier for each User)
//	2) Uname (Cannot be Blank)
//	3) Email (Cannot be Blank)
//	4) Password (Cannot be blank, min 6 characters)
//	5) City (Cannot be Blank)
//	6) Contact_No (Cannot be blank, min 10 digit)
//	7) Birth_Date(Cannot be Blank)

	
	@Column(name = "user_name")
	private String userName;
	
	private String email;
	
	private String password;
	
	private String city;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	
	private LocalDate birthDate;
	
	

}
