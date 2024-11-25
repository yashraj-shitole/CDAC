package com.fileio;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int rollNo;
	String name;
	ArrayList<Double> marks=new ArrayList<>(3);
	
	
	public Student() {
		
	}
	
	public Student(int rollNo,String name,Double math,Double english,Double science) {
		
	this.rollNo=rollNo;
	this.name=name;
	marks.add(math);
	marks.add(english);
	marks.add(science);
		
	}
	
	public void acceptData(Scanner sc) {
		System.out.print("Enter roll number:");
		this.rollNo=sc.nextInt();
		System.out.print("Enter name of student");
		this.name=sc.next();
		System.out.print("Enter math marks");
		marks.add(sc.nextDouble());
		System.out.print("Enter english marks");
		marks.add(sc.nextDouble());		
		System.out.print("Enter science science");
		marks.add(sc.nextDouble());
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList< Double> getMarks() {
		return marks;
	}

	public void setMarks(ArrayList<Double> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}

	
	
	
	
	
	
}
