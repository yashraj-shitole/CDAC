package com.school.dto;

import java.time.LocalDate;

import com.school.pojo.Category;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

	
	@NotBlank(message = "Name must not be null")
	private String name;
	
	private Category category;
	
	@NotNull(message = "Start date must not be null")
	private LocalDate startDate;
	
	@NotNull(message = "End date must not be null")
	private LocalDate endDate;
	private double fee;
	
	
}
