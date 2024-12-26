package com.school.pojo;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="courses")
public class Course extends Base {

	
	
	@Column(nullable = false)
	private String name;
	
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Category category;
	
	@Column(name = "start_date",nullable = false)
	private LocalDate startDate;
	
	@Column(name = "end_date",nullable = false)
	private LocalDate endDate;
	
	@Column(nullable = false)
	private double fee;
	
	@Column(nullable = false)
	private String grade;
	
	
}

//1. ID (unique identifier for each Course, auto generated, starts from 1)
//2. Name (Cannot be Blank, Example : JAVA01, JAVA02, WEBJAVA01, WEBJAVA02)
//3. Category (Enum, Example: JAVA-BEGINER, JAVA-ADVANCED)
//4. Start Date (Cannot be Blank)
//5. End Date (Cannot be Blank)
//6. Fee (Cannot be Blank)
//7. Grade to Pass (Cannot be Blank)