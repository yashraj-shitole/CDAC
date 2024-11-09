package com.sunbeam.daos;

import java.util.ArrayList;

import com.sunbeam.entities.Candidate;

public interface CandidateDao extends AutoCloseable{

	ArrayList<Candidate> findAllCandidates() throws Exception; 
	Candidate findCandidateById(int id) throws Exception;
	int saveCandidate(Candidate c) throws Exception;
	int updateCandidate(Candidate c) throws Exception;
	int deleteCandidateById(int id) throws Exception;
	
}
