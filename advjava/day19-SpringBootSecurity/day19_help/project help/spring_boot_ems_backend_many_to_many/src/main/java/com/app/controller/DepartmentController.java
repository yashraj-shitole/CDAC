package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DepartmentDTO;
import com.app.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	// dep
	@Autowired
	private DepartmentService departmentService;

	// add new department
	@PostMapping
	@Operation(summary = "Launch New Department")
	public ResponseEntity<?> addNewDepartment(@RequestBody @Valid DepartmentDTO dept) {
		System.out.println("in add dept " + dept);
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addNewDepartment(dept));
	}
}
