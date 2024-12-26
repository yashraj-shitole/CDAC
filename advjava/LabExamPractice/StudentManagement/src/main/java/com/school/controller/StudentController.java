package com.school.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.StudentDTO;
import com.school.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> postMethodName(@RequestBody @Valid StudentDTO student) {
		//TODO: process POST request
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
	}
	
	
	
	
}
