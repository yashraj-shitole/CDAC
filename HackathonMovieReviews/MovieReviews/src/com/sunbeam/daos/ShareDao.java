package com.sunbeam.daos;

import java.util.ArrayList;

import com.sunbeam.entities.Reviews;
import com.sunbeam.entities.Shares;

public interface ShareDao extends AutoCloseable{
	
	

	int shareReview(int movieid,int userid) throws Exception;
	ArrayList<Reviews> displaySharedReviews(int id) throws Exception; 


	
	
	
}
