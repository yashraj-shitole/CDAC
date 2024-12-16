package com.sunbeam.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.EmployeeReqDto;
import com.sunbeam.dto.EmployeeRespDto;
import com.sunbeam.pojo.Employee;


public interface EmployeeService {

	List<EmployeeRespDto> getAllEmployees();

	EmployeeRespDto getEmployee(Long id);

	ApiResponse addEmployee(EmployeeRespDto employee);

	Object deleteEmployee(Long id);

	Object updateEmployee( Employee employee);

	
}
