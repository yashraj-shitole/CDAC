package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddEmployeeDTO;
import com.app.dto.EmployeeRespDTO;
import com.app.entities.Address;
import com.app.entities.Department;
import com.app.entities.Employee;
import com.app.entities.Project;
import com.app.repository.AddressRepository;
import com.app.repository.DepartmentRepository;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dep
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressRepository adrRepo;

	@Autowired
	private DepartmentRepository deptRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<EmployeeRespDTO> getAllEmployeesFromDept(long deptId) {
		List<Employee> empList = empRepo.findByDeptId(deptId);
		return empList.stream().map(emp -> mapper.map(emp, EmployeeRespDTO.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteEmpDetails(long empId) {
		// checking if adr is assigned for this emp , using emp id (=adr id : since have used : @MapsId)
		Optional<Address> optionalAdr = adrRepo.findById(empId);
		if (optionalAdr.isPresent()) // child rec : adr exists ,so first delete that
			adrRepo.delete(optionalAdr.get());
		// what is the relationship between Emp n Project ?
		// Employee *<--------->* Project : both are parents , child : join table
		// (project_emps)
		// You will have to delete those links in the join table , for the emp assigned
		// to the project first
		// n then delete parent emp record
		Employee emp = empRepo.findById(empId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		Iterator<Project> projectItr = emp.getProjects().iterator();
		while (projectItr.hasNext())
			projectItr.next().getEmps().remove(emp);
		empRepo.delete(emp);
		return "Emp Details deleted along with it's child recs";
	}

	@Override
	public EmployeeRespDTO addNewEmployee(AddEmployeeDTO dto) {

		// validate confirm password
		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			Department dept = deptRepo.findById(dto.getDeptId())
					.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
			Employee empEntity = mapper.map(dto, Employee.class);
			dept.addEmployee(empEntity);
			Employee savedEmp = empRepo.save(empEntity);
			System.out.println("emp entity id " + empEntity.getId() + " " + savedEmp.getId());
			return mapper.map(savedEmp, EmployeeRespDTO.class);
		}
		throw new ApiException("Passwords don't match");

	}

	@Override
	public EmployeeRespDTO updateEmployee(Long empId, AddEmployeeDTO dto) {
		// validate if emp exists by id
		Employee emp = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emo ID , Emp not found !!!!"));
		// => emp exists
		// validate confirm password
		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			Department dept = deptRepo.findById(dto.getDeptId())
					.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
			// dto contains the updates , so apply it --> to entity
			//In DTO id property is : @JsonProperty(access = Access.READ_ONLY)
			//so it's not used during de-ser : so value would be null
			mapper.map(dto, emp);// Since ModelMapper config is modified in Application class , null value does not get copied to entity
			//so no need to set it again
	//		emp.setId(empId);// so setting it again
			System.out.println("after map " + emp);
			dept.addEmployee(emp);
			// Employee savedEmp = empRepo.save(empEntity);
			// System.out.println("emp entity id " + emp.getId());
			return mapper.map(emp, EmployeeRespDTO.class);
		}
		throw new ApiException("Passwords don't match");

	}

	@Override
	public EmployeeRespDTO getEmpDetails(long deptId, Long empId) {
		Employee employee = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
		if(employee.getDept().getId() != deptId)
			throw new ResourceNotFoundException("Dept id does not match !!!");
			
		return mapper.map(employee, EmployeeRespDTO.class);
	}

}
