package com.sunbeam.application;

import java.util.ArrayList;

import com.sunbeam.daoimplimetation.ReviewsDaoImplementation;
import com.sunbeam.entities.Reviews;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			try(ReviewsDaoImplementation cdi=new ReviewsDaoImplementation()){
				
				Reviews c=cdi.findReviewById(8);
					System.out.println(c);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		

	}
	
	
	

}
