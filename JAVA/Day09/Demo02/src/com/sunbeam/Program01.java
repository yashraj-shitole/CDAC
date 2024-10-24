package com.sunbeam;

public class Program01 {

	// till java 1.4
	public static void displayArray(Object[] arr) {
		for (Object obj : arr)
			System.out.print(obj + ", ");
		System.out.println();

	}

	// from java 1.5 onwards
	public static <T> void printArray(T[] arr) {
		for (T obj : arr)
			System.out.print(obj + ", ");
		System.out.println();

	}

	public static void main(String[] args) {
		Integer[] arr1 = { 10, 20, 30, 40, 50 };
		Double[] arr2 = { 11.22, 22.33, 33.44, 44.55, 55.66 };
		String[] arr3 = { "Anil", "Mukesh", "Ramesh", "Suresh" };

		// displayArray(arr1);
		// displayArray(arr2);
		// displayArray(arr3);

		// Program01.<Integer>printArray(arr2); // NOT OK
		// Program01.<Integer>printArray(arr3); // NOT OK
		Program01.<Integer>printArray(arr1); // OK
		printArray(arr2); // OK
		printArray(arr3);
	}

}
