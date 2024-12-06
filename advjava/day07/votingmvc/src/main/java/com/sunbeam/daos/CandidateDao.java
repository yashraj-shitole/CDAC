/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Candidate;

public interface CandidateDao extends AutoCloseable {
	List<Candidate> findAll() throws Exception;
	Candidate findById(int id) throws Exception;
	int save(Candidate c) throws Exception;
	int update(Candidate c) throws Exception;
	int deleteById(int id) throws Exception;
	int incrVote(int candId) throws Exception;
}
