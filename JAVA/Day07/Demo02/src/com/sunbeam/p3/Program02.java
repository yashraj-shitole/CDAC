package com.sunbeam.p3;

import java.util.Scanner;

public class Program02 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter the numerator - ");
			int n = sc.nextInt();
			System.out.print("Enter the denominator - ");
			int d = sc.nextInt();
			int result = n / d;
			System.out.println("Division = " + result);
		}

		System.out.println("Proggram Finished");
	}

}
