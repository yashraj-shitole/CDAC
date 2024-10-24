package com.sunbeam.students;

import java.util.Scanner;

public class Students implements Comparable<Students> {

	private int roll;
	private String name;
	private String city;
	private double marks;
	private static int rollIncrement=1;
	
	{
		roll=rollIncrement;
		rollIncrement++;
	}
	
	public Students(){
		
	}
	
	public Students(String name,String city,double marks) {
		this.name=name;
		this.city=city;
		this.marks=marks;
		
	}
	
	public void acceptData(Scanner sc) {
		
		
		System.out.print("Enter name: ");
		this.name=sc.next();
		System.out.print("Enter city: ");
		this.city=sc.next();
		System.out.print("Enter marks: ");
		this.marks=sc.nextDouble();
		
	}
	
	public void displayData() {
		System.out.println("Roll no: "+roll);
		System.out.print("Name: "+name);
		System.out.println("City: "+city);
		System.out.println("Marks: "+marks);
	}

	@Override
	public String toString() {
		return "Students [Roll=" + roll + ", Name=" + name + ", City=" + city + ", Marks=" + marks + "]";
	}

	@Override
	public int compareTo(Students students) {
		return this.roll - students.roll;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
	

}
