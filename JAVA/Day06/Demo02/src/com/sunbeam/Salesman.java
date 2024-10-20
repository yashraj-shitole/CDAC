package com.sunbeam;

import java.util.Scanner;

public class Salesman extends Employee {
	int sales;
	double commission;

	public Salesman() {
	}

	public Salesman(int empid, String name, double salary, int sales, double commission) {
		super(empid, name, salary);
		this.sales = sales;
		this.commission = commission;
	}

	@Override
	public void accept(Scanner sc) {
		super.accept(sc);
		System.out.print("Enter No of sales done - ");
		sales = sc.nextInt();
		System.out.print("Enter commission per sale - ");
		commission = sc.nextDouble();
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Sales - " + sales);
		System.out.println("Commission - " + commission);
	}

	@Override
	public void calculateTotalSalary() {
		System.out.println("Total Salary = " + (salary + sales * commission));
	}

}
