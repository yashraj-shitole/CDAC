package com.sunbeam.p1;

import java.util.Scanner;

public class Employee extends Person {
	int empid;
	double salary;

	public Employee() {
		System.out.println("Employee()");
	}

	public Employee(int empid, double salary) {
		System.out.println("Employee(int,double)");
		this.empid = empid;
		this.salary = salary;
	}

	public Employee(int empid, String name, double salary) {
		super(name);
		System.out.println("Employee(int,String,double)");
		this.empid = empid;
		this.salary = salary;
	}

	public void acceptEmployee(Scanner sc) {
		System.out.print("Enter the empid - ");
		empid = sc.nextInt();

		this.acceptPerson(sc);

		System.out.print("Enter the salary - ");
		salary = sc.nextDouble();
	}

	public void displayEmployee() {
		System.out.println("Empid - " + empid);
		displayPerson();
		System.out.println("Salary - " + salary);
	}

}
