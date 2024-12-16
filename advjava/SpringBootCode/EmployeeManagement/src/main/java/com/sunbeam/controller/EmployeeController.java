package com.sunbeam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.EmployeeReqDto;
import com.sunbeam.dto.EmployeeRespDto;
import com.sunbeam.pojo.Employee;
import com.sunbeam.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	//get all employees
	@GetMapping("/")
	public ResponseEntity<?> getAllEmployees() {
		
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	//get employee
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id) {
		
		try {			
			EmployeeRespDto employee=employeeService.getEmployee(id);
			return ResponseEntity.ok(employee);
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));	
		}

	}
	
	
	
	//add
	@PostMapping("/")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeRespDto employee ) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(employeeService.addEmployee(employee));
	}
	
	
	//delete
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> deleteCategoryDetails(@PathVariable() Long Id)
	{
		try {
			//invoke service layer method
			return ResponseEntity.ok(
			employeeService.deleteEmployee(Id));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	//update
	@PutMapping("/")
	public ResponseEntity<?> putMethodName(@RequestBody Employee employee) {
		
		
		
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}
	
	
	

}
