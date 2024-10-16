package com.sunbeam;

public class Program02 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		// for-each
		for (int element : arr) {
			System.out.println("Element = " + element);
		}

	}

}
