package com.app.service;

import java.util.List;

import com.app.dto.DepartmentDTO;
import com.app.entities.Department;

public interface DepartmentService {
	List<Department> getAllDepartmens();
	Department getDepartmentDetails(long deptId);
	DepartmentDTO addNewDepartment(DepartmentDTO dept);
}
