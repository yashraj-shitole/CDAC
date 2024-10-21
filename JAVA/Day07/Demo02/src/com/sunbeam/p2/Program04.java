package com.sunbeam.p2;

import java.util.Scanner;

public class Program04 {

	public static void division() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the numerator - ");
		int n = sc.nextInt();
		System.out.print("Enter the denominator - ");
		int d = sc.nextInt();

		int result = n / d;
		System.out.println("Division = " + result);
	}

	public static void main(String[] args) {
		try {
			division();
		} catch (Exception e) // Generic Catch block
		{
			e.printStackTrace();
		}
		System.out.println("Program completed...");
	}

}
