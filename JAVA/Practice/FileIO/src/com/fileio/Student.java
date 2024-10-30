package com.fileio;

import java.util.*;

public class Student {

	int rollNo;
	String name;
	LinkedHashMap<String,Double> marks=new LinkedHashMap<>(3);
	
	
	public Student() {
		
	}
	
	public Student(int rollNo,String name,Double math,Double english,Double science) {
		
	this.rollNo=rollNo;
	this.name=name;
	marks.put("Math", math);
	marks.put("English", english);
	marks.put("Science", science);
		
	}
	
	public void acceptData(Scanner sc) {
		System.out.print("Enter roll number:");
		this.rollNo=sc.nextInt();
		System.out.print("Enter name of student");
		this.name=sc.next();
		System.out.print("Enter math marks");
		marks.put("Math", sc.nextDouble());
		System.out.print("Enter english marks");
		marks.put("English", sc.nextDouble());		
		System.out.print("Enter science science");
		marks.put("Science", sc.nextDouble());
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

	public LinkedHashMap<String, Double> getMarks() {
		return marks;
	}

	public void setMarks(LinkedHashMap<String, Double> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
	
}
