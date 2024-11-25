package com.sunbeam.daos;



import java.util.*;

import com.sunbeam.entities.*;


public interface ReviewsDao extends AutoCloseable{

		
	
	ArrayList<Reviews> findAllReviews() throws Exception; 
	Reviews findReviewById(int id) throws Exception;
	int saveReview(Reviews c) throws Exception;
	int updateReview(Reviews c, int user_id) throws Exception;
	int deleteReviewById(int id) throws Exception;
	
	
}
