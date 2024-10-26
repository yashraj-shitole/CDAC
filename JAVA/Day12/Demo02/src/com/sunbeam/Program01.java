package com.sunbeam;

import java.util.Scanner;

interface Shape {
	void accept(Scanner sc);

	void calculateArea();

	default void calculatePerimeter() {

	}

	static Shape shapefactory(int choice) {
		switch (choice) {
		case 1:
			return new Circle();
		case 2:
			return new Rectangle();
		}
		return null;
	}
}

class Circle implements Shape {
	int radius;

	@Override
	public void accept(Scanner sc) {
		System.out.print("Enter radius - ");
		radius = sc.nextInt();
	}

	@Override
	public void calculateArea() {
		System.out.println("Area of Circle = " + (3.14 * radius * radius));
	}

}

class Rectangle implements Shape {
	int length;
	int breadth;

	@Override
	public void accept(Scanner sc) {
		System.out.print("Enter length - ");
		length = sc.nextInt();
		System.out.print("Enter breadth - ");
		breadth = sc.nextInt();
	}

	@Override
	public void calculateArea() {
		System.out.println("Area of Rectangle = " + (length * breadth));
	}

	@Override
	public void calculatePerimeter() {
		System.out.println("Perimeter of Rectangle = " + (2 * (length + breadth)));
	}

}

public class Program01 {
	public static int menu(Scanner sc) {
		System.out.println("0. EXIT");
		System.out.println("1. Area of Circle");
		System.out.println("2. Area of Rectangle");
		return sc.nextInt();

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shape s;
		int choice;
		while ((choice = menu(sc)) != 0) {
			switch (choice) {
			case 1:
			case 2:
				s = Shape.shapefactory(choice);
				s.accept(sc);
				s.calculateArea();
				s.calculatePerimeter();
				break;

			default:
				System.out.println("Wrong choice...");
				break;
			}
		}

	}

}
