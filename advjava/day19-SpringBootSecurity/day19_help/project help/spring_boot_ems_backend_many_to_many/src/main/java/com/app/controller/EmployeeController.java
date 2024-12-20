package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddEmployeeDTO;
import com.app.service.EmployeeService;
import com.app.service.ImageHandlingService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ImageHandlingService imageService;

	// add new emp to existing dept
	// http://host:port/employees , method=POST
	@PostMapping
	@Operation(summary = "Add new emp to existing dept")
	public ResponseEntity<?> addNewEmployee(@RequestBody @Valid AddEmployeeDTO dto) {
		System.out.println("in add emp " + dto);
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(employeeService.addNewEmployee(dto));
	}
	// http://host:port/employees/departments/{deptId} , method=GET
		@GetMapping(value = "/departments/{deptId}")
		@Operation(summary = "Get all emps' details from specified dept")
		public ResponseEntity<?> getEmpDetailsByDepartment(@PathVariable Long deptId) throws IOException {
			System.out.println("get emps by dept "+deptId);
			return ResponseEntity.ok(employeeService.getAllEmployeesFromDept(deptId));
		}
		
		// http://host:port/employees/departments/{deptId}/{empId}
		// add req handling method(API end point) to get emp details by emp id n dept id
		@GetMapping("/departments/{deptId}/{empId}")
		@Operation(summary = "Get specific emp's  details from specified dept")
		//dept id is here just used for validation 
		public ResponseEntity<?> getEmpDetailsByDeptAndEmpId(@PathVariable Long deptId,@PathVariable Long empId) {
			System.out.println("in get emp details by dept id n emp id " +deptId+" "+ empId);
			return ResponseEntity.ok(employeeService.getEmpDetails(deptId,empId));
		}
		

		//update  emp details
		// http://host:port/employees/{empId} , method=PUT
		@PutMapping("/{empId}")
		@Operation(summary = "Update emp details")		
		public ResponseEntity<?> updateEmployee(@PathVariable Long empId,  @RequestBody @Valid AddEmployeeDTO dto) {
			System.out.println("in update emp " +empId+" "+ dto);
			return ResponseEntity.
					ok(employeeService.updateEmployee(empId,dto));
		}

	// http://host:port/employees/images , method=POST
	@PostMapping(value = "/images", consumes = "multipart/form-data")
	@Operation(summary = "Upload image for a specific emp , to be stored on server side folder")	
	public ResponseEntity<?> uploadImage(@RequestParam long empId, @RequestParam MultipartFile image)
			throws IOException {
		System.out.println("in upload image " + empId);
		return ResponseEntity.status(HttpStatus.CREATED).body(imageService.uploadImage(empId, image));
	}

	// http://host:port/employees/images/{empId} , method=GET
	@GetMapping(value = "/images/{empId}", produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	@Operation(summary = "Server/ download image for a specific emp , from  server side folder")	
	public ResponseEntity<?> downloadImage(@PathVariable long empId) throws IOException {
		System.out.println("in download image " + empId);
		return ResponseEntity.ok(imageService.serveImage(empId));
	}
	
	// Delete specific emp details (Use case : Emp resigned or got fired unfortunately !! )
		// URL : http://host:port/employees/{empId} , method=DELETE
		@DeleteMapping("/{empId}")
		@Operation(summary = "Delete specific Emp's Details")
		public ResponseEntity<?> deleteEmpDetails(@PathVariable Long empId) {
			System.out.println("in del emp " + empId);
			return ResponseEntity.ok(employeeService.deleteEmpDetails(empId));
		}

}
