package com.sunbeam.p2;

class Employee {
	private int empid;
	private double salary;

	// cannot override in the subclass
	public final void setEmpid(int empid) {
		this.empid = empid;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void accept() {
		System.out.println("Employee :: accept(id,salary)");
	}

	public void display() {
		System.out.println("Employee :: display");
	}

}

class Manager extends Employee {
	double bonus;

	@Override
	public void accept() {
		super.accept();
		System.out.println("Bonus");
	}
}

public class Program01 {

	public static void main(String[] args) {

	}

}
