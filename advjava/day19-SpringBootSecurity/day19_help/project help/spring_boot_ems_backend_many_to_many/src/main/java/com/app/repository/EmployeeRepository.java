package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByDeptId(long deptId);
}
