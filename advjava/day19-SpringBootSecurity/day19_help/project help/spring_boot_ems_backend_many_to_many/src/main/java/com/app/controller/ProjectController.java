package com.app.controller;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProjectDTO;
import com.app.dto.ProjectEmp;
import com.app.service.ProjectService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/projects")
@Validated //required for validating request param n path vars
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	public ProjectController() {
		System.out.println("in ctor of " + getClass());
	}

	// http://host:port/projects , method=POST
	@PostMapping
	@Operation(summary = "Launch New Project")
	public ResponseEntity<?> launchNewProject(@RequestBody @Valid ProjectDTO project) {
		System.out.println("in add proj " + project);
		return ResponseEntity.status(HttpStatus.CREATED).body(projectService.launchNewProject(project));
	}

	/*
	 * 
	 * 
	 * ApiResponse assignEmpToProject(Long projectId, Long empId); ApiResponse
	 * removeEmpFromProject(Long projectId, Long empId);
	 */
	// http://host:port/projects , method=GET

	@GetMapping
	@Operation(summary = "Get All Projects Details")
	public ResponseEntity<?> getAllProjects() {
		System.out.println("in get all projs");
		return ResponseEntity.ok(projectService.getAllProjects());
	}

	// http://host:port/projects/employees , method=POST
	@PostMapping("/employees")
	@Operation(summary = "Add Specified emp to specified project")
	public ResponseEntity<?> addEmployeeToProject(@RequestBody ProjectEmp projectEmp) {
		System.out.println("in add emp to proj " + projectEmp);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(projectService.assignEmpToProject(projectEmp.getProjectId(), projectEmp.getEmployeeId()));
	}

	// http://host:port/projects/employees , method=DELETE
	@DeleteMapping("/employees")
	@Operation(summary = "Remove Specified emp from specified project")
	public ResponseEntity<?> removeEmployeeFromProject(@RequestBody ProjectEmp projectEmp) {
		System.out.println("in rem emp to proj " + projectEmp);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(projectService.removeEmpFromProject(projectEmp.getProjectId(), projectEmp.getEmployeeId()));
	}

	// Delete specific project details (Use case : Project got cancelled )
	// URL : http://host:port/projects/{projectId} , method=DELETE
	@DeleteMapping("/{projectId}")
	@Operation(summary = "Delete specific Project's Details")
	public ResponseEntity<?> deleteProjectDetails(@PathVariable Long projectId) {
		System.out.println("in del project " + projectId);
		return ResponseEntity.ok(projectService.deleteProjectDetails(projectId));
	}
	
	// http://host:port/projects , method=PUT
		@PutMapping("/{projectId}")
		@Operation(summary = "Updating Complete project details")
		public ResponseEntity<?> updateProject(@PathVariable Long projectId, @RequestBody @Valid ProjectDTO dto) {
			System.out.println("in update proj " + projectId + " " + dto);
			return ResponseEntity.ok().body(projectService.updateProject(projectId, dto));
		}
	
	// update project details  partial
			// http://host:port/projects/{projectId} , method=PATCH
			@PatchMapping("/{projectId}")
			@Operation(summary = "Partial updation of project details")
			public ResponseEntity<?> updateProjectDetails(@PathVariable @NotNull Long projectId,
					@RequestBody Map<String, Object> map) throws Exception{
				System.out.println("in partial update adr " + projectId + " " + map);
				return ResponseEntity.ok()
						.body(projectService.patchProjectDetails(projectId, map));
			}
			

}
