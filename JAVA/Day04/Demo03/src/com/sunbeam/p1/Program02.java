package com.sunbeam.p1;

class Circle {
	int radius;
	static final double PI = 3.14;

	public Circle(int radius) {
		this.radius = radius;
	}

	public void calculateArea() {
		System.out.println("Area = " + (PI * radius * radius));
	}

}

public class Program02 {

	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(7);
		Circle c3 = new Circle(9);

		c1.calculateArea();
		c2.calculateArea();
		c3.calculateArea();
	}

}
