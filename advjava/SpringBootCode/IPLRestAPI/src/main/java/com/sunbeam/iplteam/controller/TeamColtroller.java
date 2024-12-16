package com.sunbeam.iplteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.iplteam.pojos.IPLTeam;
import com.sunbeam.iplteam.service.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/teams")
@CrossOrigin
public class TeamColtroller {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/")
	public ResponseEntity<?> getTeam() {
		
		List<IPLTeam> teams=teamService.getAllTeams();
		if (teams.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.ok(teams);			
		}	
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> addTeam(@RequestBody IPLTeam team) {
		
		System.out.println(team);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addTeam(team));
	}
	
	
	
	
}
