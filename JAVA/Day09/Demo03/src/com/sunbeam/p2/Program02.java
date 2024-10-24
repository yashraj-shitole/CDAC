package com.sunbeam.p2;

import java.util.Arrays;
import java.util.Comparator;

public class Program02 {

	public static void main(String[] args) {
		Employee[] arr = new Employee[5];
		arr[0] = new Employee(5, "Mukesh", 20000);
		arr[1] = new Employee(1, "Anil", 50000);
		arr[2] = new Employee(4, "Suresh", 10000);
		arr[3] = new Employee(3, "Ramesh", 30000);
		arr[4] = new Employee(2, "Sham", 40000);

		System.out.println("Before Sorting-->");
		for (Employee e : arr)
			System.out.println(e);

		class EmpNameComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.name.compareTo(o2.name);
			}
		}
		EmpNameComparator nameComparator = new EmpNameComparator();

		// Arrays.sort(arr);
		Arrays.sort(arr, nameComparator);

		System.out.println();
		System.out.println("After Sorting based on Name-->");
		for (Employee e : arr)
			System.out.println(e);

	}

}
