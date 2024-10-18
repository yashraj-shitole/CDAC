package com.app.geometry;

public class Point2D {

	double xCoordinate;
	double yCoordinate;
	
	public Point2D(double xCoordinate, double yCoordinate) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
	}
	
	
	 public String getDetails() {
		 
		 return "X co-ordinate: "+xCoordinate+"   Y co-ordinate: "+yCoordinate;
	 }

	 public boolean isEqual(Point2D p) {
		
		 if(this.xCoordinate == p.getXCoordinate() && this.yCoordinate == p.getYCoordinate()) {
			 return true;
		 }
		 else{
			 return false;
		}
	}
	 
	 public double getXCoordinate() {
		
		 return xCoordinate;
	}
	 public double getYCoordinate() {
			
		 return yCoordinate;
	}
	 
	 public double calculateDistance(Point2D pointObject) {
		
//		 √((x2 – x1)² + (y2 – y1)²)
		 double distance;
		 
		 distance= Math.sqrt(((Math.pow((this.xCoordinate-pointObject.getXCoordinate()), 2))+(Math.pow((this.yCoordinate-pointObject.getYCoordinate()), 2))));
		 
		 return distance;
	}
	
}
