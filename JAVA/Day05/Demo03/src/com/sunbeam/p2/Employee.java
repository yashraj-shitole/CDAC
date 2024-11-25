package com.sunbeam.p2;

import java.util.Scanner;

public class Employee extends Person {
	int empid;
	double salary;

	public Employee() {
	}

	public Employee(int empid, String name, double salary) {
		super(name);
		this.empid = empid;
		this.salary = salary;
	}

	public void accept(Scanner sc) {
		System.out.print("Enter the empid - ");
		empid = sc.nextInt();

		super.accept(sc);

		System.out.print("Enter the salary - ");
		salary = sc.nextDouble();
	}

	public void display() {
		System.out.println("Empid - " + empid);
		super.display();
		System.out.println("Salary - " + salary);
	}

	public void calculateTax() {
		System.out.println("Tax to be paid = " + (0.1 * salary));
	}

}
