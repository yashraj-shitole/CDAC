package com.sunbeam.p1;

public class Program02 {

	public static void m1() {
		double num1 = 10;
		m1();
	}

	public static void main(String[] args) {
		m1();
		System.out.println("Program Executed...");
	}

}
