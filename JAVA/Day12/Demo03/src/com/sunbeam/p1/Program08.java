package com.sunbeam.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program08 {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(4, "Suresh", 20000));
		empList.add(new Employee(1, "Ramesh", 50000));
		empList.add(new Employee(5, "Anil", 30000));
		empList.add(new Employee(2, "Sham", 40000));
		empList.add(new Employee(3, "Mukesh", 10000));

		System.out.println("Before Sorting --> ");
		empList.forEach(e -> System.out.println(e));

		Collections.sort(empList, (e1, e2) -> e1.name.compareTo(e2.name));

		System.out.println();
		System.out.println("After Sorting --> ");
		// empList.forEach(e -> System.out.println(e));
		empList.forEach(System.out::println); // Method references
	}

}
