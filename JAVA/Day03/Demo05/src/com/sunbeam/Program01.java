package com.sunbeam;

public class Program01 {
	public static void main(String[] args) {
		int arr[]; // reference
		arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Element = " + arr[i]);
		}

		System.out.println("Element from index 2 = " + arr[2]);// 30
		System.out.println("Element from index 6 = " + arr[6]); // ArrayIndexOutOfBoundsException
	}

}
