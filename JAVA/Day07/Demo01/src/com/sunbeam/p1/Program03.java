package com.sunbeam.p1;

import java.util.Scanner;

interface Shape {
	double PI = 3.14;

	void acceptData(Scanner sc);

	void calculateArea();
}

class Rectangle implements Shape {
	int length;
	int breadth;

	@Override
	public void acceptData(Scanner sc) {
		System.out.print("Enter length - ");
		length = sc.nextInt();
		System.out.print("Enter breadth - ");
		breadth = sc.nextInt();

	}

	@Override
	public void calculateArea() {
		System.out.println("Area of Rectangle - " + (length * breadth));
	}
}

class Circle implements Shape {
	int radius;

	@Override
	public void acceptData(Scanner sc) {
		System.out.print("Enter the radius - ");
		radius = sc.nextInt();
	}

	@Override
	public void calculateArea() {
		System.out.println("Area of Circle - " + (PI * radius * radius));
	}

}

public class Program03 {
	public static int menu(Scanner sc) {
		System.out.println("0. Exit");
		System.out.println("1. Area of Rectangle");
		System.out.println("2. Area of Circle");
		System.out.print("Enter choice - ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shape s = null;
		int choice;
		while ((choice = menu(sc)) != 0) {
			switch (choice) {
			case 1:
				s = new Rectangle();
				break;
			case 2:
				s = new Circle();
				break;
			default:
				System.out.println("Wrong Choice...");
				break;
			}
			if (s != null) {
				s.acceptData(sc);
				s.calculateArea();
				s = null;
			}
		}

	}

}
