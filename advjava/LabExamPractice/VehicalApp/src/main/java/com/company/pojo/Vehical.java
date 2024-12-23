package com.company.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicals")
public class Vehical extends Base {

//	1) Id (unique identifier for each Vehicle, auto generated, starts from 1)
//	2) Vname (Cannot be Blank, Example: Splendor, Amaze, Pulsar, etc.)
//	3) Company (Enum, Example: Hero, Honda, Bajaj, etc.)
//	4) Vnumber (Cannot be Blank, Example: MH09AB1111, MH10CD2222, MHEF3333, etc.)
//	5) Vtype (Cannot be Blank, Example: bike, sedan, cruiser, etc.)
//	6) Uid (User ID, FK)
//	7) purchaseDate(Cannot be Blank)
	
	
	@Column(name = "vehical_name")
	private String vehicalName;
	@Enumerated(EnumType.STRING)
	private Company company;
	
	@Column(name = "vehical_number")
	private String vehicalNumber;
	
	@Column(name = "vehical_type")
	private String vehicalType;
	
	@Column(name = "purchase_date")
	private LocalDate purchaseDate;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
