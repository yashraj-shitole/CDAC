package com.store.pojo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEnitity {
	
	@Column(length = 50)
	private String name;
	@Column(length = 20)
	private String password;
	@Column(length = 50, unique = true)
	private String email;

	private LocalDate dob;
	
	private String role;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private List<Order> orders;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

}
