package com.sunbeam.p3;

import java.util.Scanner;

public class Student extends Person {
	int rollno;
	double marks;

	public Student() {
	}

	public Student(int rollno, String name, double marks) {
		super(name);
		this.rollno = rollno;
		this.marks = marks;
	}

	@Override
	public void accept(Scanner sc) {
		System.out.print("Enter the rollno - ");
		rollno = sc.nextInt();
		super.accept(sc);
		System.out.print("Enter the marks - ");
		marks = sc.nextDouble();
	}

	@Override
	public void display() {
		System.out.println("Rollno - " + rollno);
		super.display();
		System.out.println("Marks - " + marks);
	}

	public void calculatePercentage() {
		System.out.println("Percentage = " + ((marks / 150) * 100));
	}

}
