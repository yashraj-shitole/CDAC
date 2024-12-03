package com.sunbeam.pages;
import java.util.ArrayList;

public class SubjectMarks {
	
	double marks;
	String subject;
	
	
	
	
	
	public SubjectMarks( String subject,double d) {
		super();
		this.marks = d;
		this.subject = subject;
	}
	
	
	public double getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "SubjectMarks [marks=" + marks + ", subject=" + subject + "]";
	}
	
	

}
