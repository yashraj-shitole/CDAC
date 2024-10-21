package com.sunbeam.p1;

import java.util.Scanner;

interface Acceptable {
	void accept(Scanner sc);
}

interface Displayable {
	void display();
}

class Employee implements Acceptable, Displayable {
	int id;
	String name;
	String salary;

	@Override
	public void accept(Scanner sc) {
		System.out.println("Employee::accept");
	}

	@Override
	public void display() {
		System.out.println("Employee::display");
	}

}

class Point implements Acceptable {
	int x;
	int y;

	@Override
	public void accept(Scanner sc) {
		System.out.println("Point::accept");
	}

}

public class Program01 {

	public static void main(String[] args) {
		Acceptable a1 = new Employee();
		// Acceptable a1 = new Point();

		a1.accept(null);

	}

}
