package com.sunbeam;

import java.util.Scanner;

public abstract class Employee {
	int empid;
	String name;
	double salary;

	public Employee() {
	}

	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}

	public void accept(Scanner sc) {
		System.out.print("Enter the empid - ");
		empid = sc.nextInt();
		System.out.print("Enter the name - ");
		name = sc.next();
		System.out.print("Enter the salary - ");
		salary = sc.nextDouble();
	}

	public void display() {
		System.out.println("Empid - " + empid);
		System.out.println("Name - " + name);
		System.out.println("Salary - " + salary);
	}

	// implemention of the method is 100% incomplete
	public abstract void calculateTotalSalary();

}
