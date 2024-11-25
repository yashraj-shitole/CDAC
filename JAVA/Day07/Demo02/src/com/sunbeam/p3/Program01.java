package com.sunbeam.p3;

import java.util.Scanner;

public class Program01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter the numerator - ");
			int n = sc.nextInt();
			System.out.print("Enter the denominator - ");
			int d = sc.nextInt();
			int result = n / d;
			System.out.println("Division = " + result);
		} finally {
			System.out.println("Inside Finally");
			sc.close();
		}

		System.out.println("Proggram Finished");
	}

}
