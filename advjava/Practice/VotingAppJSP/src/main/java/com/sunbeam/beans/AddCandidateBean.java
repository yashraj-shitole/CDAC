package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entity.Candidate;

public class AddCandidateBean {

	
	String name;
	String party;
	
	public AddCandidateBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addCandidate() {
	
		
		Candidate c=new Candidate(0, name, party, 0);
		
		try(CandidateDao candidateDao=new CandidateDaoImpl()){
			
			int count=candidateDao.save(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	
	
	
	
	
	
}
