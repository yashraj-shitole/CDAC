package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class VoteResultBean {
	
	int id;
	
	
	public VoteResultBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean vote() {
		
		try(CandidateDao candidateDao=new CandidateDaoImpl()){
			int count= candidateDao.incrVote(id);
			
			if(count==1) {
				System.out.println("Reached");
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "VoteResultBean [id=" + id + "]";
	}
	
	

}
