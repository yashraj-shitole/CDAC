package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.AddEmployeeDTO;
import com.app.dto.EmployeeRespDTO;

public interface EmployeeService {
//get list of emps from a specific dept
	List<EmployeeRespDTO> getAllEmployeesFromDept(long deptId);
//delete emp details
	String deleteEmpDetails(long empId);

	EmployeeRespDTO addNewEmployee(AddEmployeeDTO dto);

	EmployeeRespDTO updateEmployee(Long empId, @Valid AddEmployeeDTO dto);

	EmployeeRespDTO getEmpDetails(long deptId, Long empId);
}
