package com.sunbeam.beans;

import java.util.*;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entity.*;

public class CandidateListBean {
	
	public List<Candidate> candidateList(){
		
		List<Candidate> list=new ArrayList<>();
		
		try(CandidateDao candDao=new CandidateDaoImpl()){
			list =candDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
