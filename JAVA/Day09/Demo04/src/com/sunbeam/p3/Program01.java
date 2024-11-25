package com.sunbeam.p3;

class Date {
	int day;
	int month;
	int year;

	public Date() {
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

class Employee implements Cloneable {
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

	@Override
	protected Employee clone() throws CloneNotSupportedException {
		Employee e = (Employee) super.clone();
		e.doj = new Date();
		e.doj.day = this.doj.day;
		e.doj.month = this.doj.month;
		e.doj.year = this.doj.year;
		return e;
	}

}

public class Program01 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee("Anil", 10000, 1, 2, 2001);
		System.out.println("e1 = " + e1);
		Employee e2 = e1.clone();
		System.out.println("e2 = " + e2);

		System.out.println("After change in e2 - ");
		e2.name = "Mukesh";
		e2.doj.year = 2024;
		System.out.println("e1 = " + e1);
		System.out.println("e2 = " + e2);
	}

}
