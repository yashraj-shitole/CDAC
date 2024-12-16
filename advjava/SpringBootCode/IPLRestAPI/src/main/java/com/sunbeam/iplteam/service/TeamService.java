package com.sunbeam.iplteam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunbeam.iplteam.pojos.IPLTeam;


public interface TeamService {

	List<IPLTeam> getAllTeams();

	IPLTeam addTeam(IPLTeam team);
	
	

}
