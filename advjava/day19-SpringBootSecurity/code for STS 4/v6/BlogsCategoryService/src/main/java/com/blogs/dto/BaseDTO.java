package com.blogs.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
	@JsonProperty(access = Access.READ_ONLY)
	/*
	 * Meaning - Jackson annotation , to mark the field -Read only 
 		i.e to be used
	 * during -Serialization to be skipped during -De Serialization
	 */
	private Long id;
	// creation date
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate createdOn;
	// updation time stamp
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime updatedOn;

}
