package com.sunbeam;

public class Program03 {
	public static void main(String[] args) {
		// int[] arr = new int[-5]; // NegativeArraySizeException

		// int[] arr = new int[0];
		// System.out.println("arr[0]= " + arr[0]); // ArrayIndexOutOfBoundsException

		// int[] arr = new int[0];
		// System.out.println("length of arr = " + arr.length); // 0

		int[] arr = null;
		System.out.println("length of arr = " + arr.length); // NullPointerException
	}

}
