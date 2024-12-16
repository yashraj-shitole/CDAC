package com.blogs.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdhaarCard {
	@Column(name = "card_number", length = 20, unique = true)
	private String cardNumber;
	@Column(name = "card_created_on")
	private LocalDate createdOn;
	@Column(length = 30)
	private String location;

}
