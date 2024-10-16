package com.sunbeam;

public class Program02 {

	public static void square(int n) {
		System.out.println("Square = " + (n * n));
	}

	public static void square(double n) {
		System.out.println("Square = " + (n * n));
	}

	public static void multiply(int n1, int n2) {
		System.out.println("Multiplication = " + (n1 * n2));
	}

	public static void multiply(int n1, int n2, int n3) {
		System.out.println("Multiplication = " + (n1 * n2 * n3));
	}

	public static void division(int n, double d) {
		System.out.println("Division = " + (n / d));

	}

	public static void division(double n, int d) {
		System.out.println("Division = " + (n / d));

	}

	public static void main(String[] args) {
		square(5);
		square(5.5);
		multiply(3, 4);
		multiply(3, 4, 5);
		division(10, 2.5);
		division(12.6, 3);
	}

}
