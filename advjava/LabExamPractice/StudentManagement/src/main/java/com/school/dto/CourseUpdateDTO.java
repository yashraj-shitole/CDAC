package com.school.dto;

import java.time.LocalDate;

import com.school.pojo.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseUpdateDTO {
	

	@NotBlank
	private LocalDate startDate;
	
	@NotBlank
	private LocalDate endDate;
	
	@NotBlank
	private double fee;

}
