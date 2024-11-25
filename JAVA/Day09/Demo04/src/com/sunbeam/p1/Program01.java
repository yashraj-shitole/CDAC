package com.sunbeam.p1;

class Date {
	int day;
	int month;
	int year;

	public Date() {
		// TODO Auto-generated constructor stub
	}

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}

class Employee {
	String name;
	double salary;
	Date doj;

	public Employee() {
		doj = new Date();
	}

	public Employee(String name, double salary, int day, int month, int year) {
		this.name = name;
		this.salary = salary;
		this.doj = new Date(day, month, year);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", doj=" + doj + "]";
	}

}

public class Program01 {

	public static void main(String[] args) {
		Employee e1 = new Employee("Anil", 10000, 1, 2, 2001);
		System.out.println("e1 = " + e1);
		Employee e2 = e1;
		System.out.println("e2 = " + e2);

		System.out.println("After change in e2 - ");
		e2.name = "Mukesh";
		e2.doj.year = 2024;
		System.out.println("e1 = " + e1);
		System.out.println("e2 = " + e2);
	}

}
