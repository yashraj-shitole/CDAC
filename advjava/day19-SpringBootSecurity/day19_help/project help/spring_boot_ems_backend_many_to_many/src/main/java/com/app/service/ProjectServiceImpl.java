package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.ProjectDTO;
import com.app.entities.Employee;
import com.app.entities.Project;
import com.app.repository.EmployeeRepository;
import com.app.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ProjectDTO launchNewProject(ProjectDTO dto) {
		// map dto --> entity
		Project project = mapper.map(dto, Project.class);
		Project savedProject = projectRepo.save(project);
		return mapper.map(savedProject, ProjectDTO.class);
	}

	@Override
	public List<ProjectDTO> getAllProjects() {

		return projectRepo.findAll().stream().map(project -> mapper.map(project, ProjectDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse assignEmpToProject(Long projectId, Long empId) {
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project ID!!!!"));
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!!"));
		if (!project.addEmp(emp)) // establish bi dir relationship
			throw new ApiException("Adding Emp to the Project Failed : Emp is ALREADY assigned to the project!!!!");
		return new ApiResponse("Emp " + emp.getFirstName() + " added to Project : " + project.getTitle());
	}

	@Override
	public ApiResponse removeEmpFromProject(Long projectId, Long empId) {
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project ID!!!!"));
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!!"));
		// remove bi dir link
		if (!project.removeEmp(emp))
			throw new ApiException("Emp  removing from the Project Failed : Emp is not assigned to the project!!!!");
		return new ApiResponse("Emp " + emp.getFirstName() + " removed from Project : " + project.getTitle());
	}

	@Override
	public ApiResponse deleteProjectDetails(Long projectId) {
		//chk if project exists
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project ID!!!!"));
		// project : exists (persistent)
		// delete child records from link table : project_emps first n 
		//then delete project details
		
		Iterator<Employee> empItr = project.getEmps().iterator();
		while (empItr.hasNext())
			empItr.next().getProjects().remove(project);//To delete child recs from link table
		projectRepo.delete(project);
		return new ApiResponse("Project along with it's child records deleted successfully!");
	}

	@Override
	public ProjectDTO patchProjectDetails(Long projectId, Map<String, Object> map) {
		// chk if project exists
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project Id!!!!"));

		mapper.map(map, project);// maps ALL the changes from specified map of updated props
		System.out.println("updated project " + projectId);
		return mapper.map(project, ProjectDTO.class);
	}

	@Override
	public ProjectDTO updateProject(Long projectId, ProjectDTO dto) {
		// validate if project exists by id
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project Id !!!"));
		// => project exists
		// dto contains the updates , so apply it --> to entity
		mapper.map(dto, project);
		System.out.println("after mapping " + projectId);
		// projectRepo.save(project); NOT required since project : persistent entity. So
		// hibernate will auto sync up these changes upon commit , which happens when
		// transactional service layer method rets.
		dto.setId(projectId);// so that it doesn't send null in the json resp
		return dto;
	}

}
