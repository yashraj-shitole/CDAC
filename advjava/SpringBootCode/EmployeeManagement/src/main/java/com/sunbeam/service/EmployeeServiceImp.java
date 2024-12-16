package com.sunbeam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.EmployeeDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.EmployeeReqDto;
import com.sunbeam.dto.EmployeeRespDto;
import com.sunbeam.exception.ResourceNotFoundException;
import com.sunbeam.pojo.Employee;


@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Autowired
	private ModelMapper modelMapper;

	

	

	@Override
	public List<EmployeeRespDto> getAllEmployees() {
		
		return employeeDao.findAll()
				.stream()
				.map(employee -> modelMapper.map(employee, EmployeeRespDto.class))
				.collect(Collectors.toList());
	}



	@Override
	public EmployeeRespDto getEmployee(Long id) {
		// TODO Auto-generated method stub
		
		Employee employee=employeeDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid employee"));
		
		return modelMapper.map(employee, EmployeeRespDto.class);
	}



	@Override
	public ApiResponse addEmployee(EmployeeRespDto employee) {
		
		Employee emp=modelMapper.map(employee, Employee.class);
		
		Employee persistentEmp=employeeDao.save(emp);
		
		return new ApiResponse("Added Employee "
				+ persistentEmp.getFirstName());
	}



	@Override
	public Object deleteEmployee(Long id) {
		
		if (employeeDao.existsById(id)) {
			employeeDao.deleteById(id);
			return new ApiResponse("Employee deleted");
		}
		
		return new ResourceNotFoundException("Invalid employee");
	}



	@Override
	public Object updateEmployee(Employee employee) {
		
		if (employeeDao.existsById(employee.getId())) {
			employeeDao.save(employee);
			return new ApiResponse("Employee updated");
		}
		
		return new ApiResponse("Employee doest exist");

	}
	
	
	
	
}
