package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteBean {
	
	
	int id;
	
	
	
	public DeleteBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DeleteBean [id=" + id + "]";
	}

	public void setId(int id) {
		this.id = id;
	}


	public void deleteCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.deleteById(id);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
