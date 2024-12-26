package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.CourseDTO;
import com.school.dto.CourseUpdateDTO;
import com.school.pojo.Category;
import com.school.service.CourseService;

import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

//	1. Add new Course -----------done
//	2. Update Course Details (Start Date, End Date & Fee can be updated) --------Done
//	3. Fetch all courses matched by given Category  -----------Done
//	4. Fetch all students for given Course Name  ----------Done

	
	@Autowired
	private CourseService courseService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> postMethodName(@RequestBody @Valid CourseDTO course) {
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(course));
	}
	
	@PutMapping("/{courseid}")
	public ResponseEntity<?> postMethodName(@PathVariable Long courseid,@RequestBody @Valid CourseUpdateDTO course) {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(course, courseid));
	}
	
	@GetMapping("/{category}")
	public ResponseEntity<?> getMethodName(@PathVariable Category category) {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(courseService.getUserByCategory(category));
	}
	
	@GetMapping("/students/{courseName}")
	public ResponseEntity<?> getStudentsByCourse(@PathVariable String courseName) {
		
		
		
		return ResponseEntity.ok(courseService.getStudentsByCourse(courseName));
	}
	
	
	
	
	
	
	
	
}
