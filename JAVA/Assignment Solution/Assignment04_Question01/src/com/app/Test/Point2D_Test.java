package com.app.Test;

import com.app.geometry.*;

public class Point2D_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Point2D p1=new Point2D(7,3);
		
		Point2D p2=new Point2D(2,33);
		
		System.out.println("Point 1: "+p1.getDetails());
		System.out.println("Point 2: "+p2.getDetails());
		
		
		
		if(p1.isEqual(p2)) {
			System.out.println("Both points are located at same position");
		}
		else {			
			System.out.println("Distance between two points:  "+p1.calculateDistance(p2));
		}
		
		
		
	}

}
