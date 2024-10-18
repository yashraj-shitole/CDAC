package com.sunbeam;

import java.util.Scanner;

//Employee has-a Doj
//Employee has-a Car
public class Employee {
	int empid;
	String name;
	double salary;
	Car car; // Association

	Date doj; // Association
	{
		doj = new Date(); // (Composition)
	}

	public Employee() {
	}

	public Employee(int empid, String name, double salary, int day, int month, int year) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		doj.day = day;
		doj.month = month;
		doj.year = year;
	}

	public void acceptEmployee(Scanner sc) {
		System.out.print("Enter the empid - ");
		empid = sc.nextInt();
		System.out.print("Enter the name - ");
		name = sc.next();
		System.out.print("Enter the salary - ");
		salary = sc.nextDouble();
		System.out.println("Enter the Date of joining - ");
		doj.acceptDate(sc);
	}

	public void displayEmployee() {
		System.out.println("Empid - " + empid);
		System.out.println("Name - " + name);
		System.out.println("Salary - " + salary);
		System.out.println("DateofJoining - " + doj.getDateDetails());
		if (car != null)
			car.displayCar();
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
