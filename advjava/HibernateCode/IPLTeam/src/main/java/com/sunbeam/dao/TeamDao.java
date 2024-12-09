package com.sunbeam.dao;

import java.util.*;

import com.sunbeam.entities.IPLTeam;

public interface TeamDao {
	String addTeam(IPLTeam team);

	List<IPLTeam> getAllTeams();

	List<IPLTeam> getTeamsWithMaxAge(int maxAge, double battingAvg);

	List<String> getTeamOwnerMaxAgeAvgBatting(int maxAge, double minBattingAverage);

	Iterable<IPLTeam> getTeamOwnerAbbrevation(int maxAge, double minBattingAverage);

	void UpdateTeamAge(String teamName, int maxAge);

	void deleteTeam(Long teamId);
	
	
	

}
