package com.sunbeam.iplteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.iplteam.dao.TeamDao;
import com.sunbeam.iplteam.pojos.IPLTeam;

@Service
@Transactional
public class TeamServiceImp implements TeamService {

	@Autowired 
	private TeamDao teamDao;

	@Override
	public List<IPLTeam> getAllTeams() {

		
		return teamDao.findAll();
	}

	@Override
	public IPLTeam addTeam(IPLTeam team) {
		
		teamDao.save(team);
		
		return team;
	}
}
