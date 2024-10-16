package com.sunbeam;

public class Program01 {

	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println("d1 = " + d1.display());
		// 1/1/1900

		Date d2 = new Date(2, 10, 2024);
		System.out.println("d2 = " + d2.display());
	}

}
