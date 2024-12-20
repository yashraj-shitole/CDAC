package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.DepartmentDTO;
import com.app.entities.Department;
import com.app.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	// dep
	@Autowired
	private DepartmentRepository departmentDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Department> getAllDepartmens() {

		return departmentDao.findAll();
	}

	@Override
	public Department getDepartmentDetails(long deptId) {
		// TODO Auto-generated method stub
		return departmentDao.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
	}

	@Override
	public DepartmentDTO addNewDepartment(DepartmentDTO dept) {
		Department departmentEntity = mapper.map(dept, Department.class);
		Department persistentDept = departmentDao.save(departmentEntity);
		return mapper.map(persistentDept, DepartmentDTO.class);
	}

}
