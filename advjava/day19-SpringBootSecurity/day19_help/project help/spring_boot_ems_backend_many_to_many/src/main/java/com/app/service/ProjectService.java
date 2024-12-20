package com.app.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.ProjectDTO;

public interface ProjectService {
//add new project
	ProjectDTO launchNewProject(ProjectDTO newProject);

	List<ProjectDTO> getAllProjects();

	ApiResponse assignEmpToProject(Long projectId, Long empId);
	ApiResponse removeEmpFromProject(Long projectId, Long empId);
	//project cancellation
	ApiResponse deleteProjectDetails(Long projectId);
	//complete updation of project details
	ProjectDTO updateProject(Long projectId,ProjectDTO dto);
	//partial updation of project details
	ProjectDTO patchProjectDetails(Long projectId, Map<String, Object> map);

}
