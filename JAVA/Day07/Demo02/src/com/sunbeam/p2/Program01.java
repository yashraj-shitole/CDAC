package com.sunbeam.p2;

public class Program01 {

	public static void division(int n, int d) {
		int result = n / d;
		System.out.println("Division = " + result);
	}

	public static void main(String[] args) {
		try {
			division(10, 0);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by 0");
		}
		System.out.println("Program completed...");
	}

}
