package com.sunbeam.p1;

import java.util.Arrays;

public class Program01 {

	public static void main(String[] args) {
		int[] arr1 = { 40, 10, 50, 20, 30 };
		System.out.println("Before Sort, arr1 = " + Arrays.toString(arr1));

		Arrays.sort(arr1);
		System.out.println("After Sort, arr1 = " + Arrays.toString(arr1));
	}

}
