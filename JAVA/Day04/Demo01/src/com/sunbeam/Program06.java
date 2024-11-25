package com.sunbeam;

public class Program06 {

	// variable argument/arity method
	public static void add(int... arr) {
		int result = 0;
		for (int e : arr)
			result += e;
		System.out.println("Addition = " + result);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20 };
		add(arr);

		arr = new int[] { 10, 20, 30 };
		add(arr);

		add(new int[] { 10, 20, 30, 40 });

		add(10, 20, 30, 40, 50);

	}
}
