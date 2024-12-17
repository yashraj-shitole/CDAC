package com.store.pojo;

import java.util.List;

import jakarta.persistence.Entity;
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
public class Address extends BaseEnitity {
	
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String country;
	private int pincode;

}
