package com.sunbeam.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program07 {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(4, "Suresh", 20000));
		empList.add(new Employee(1, "Ramesh", 50000));
		empList.add(new Employee(5, "Anil", 30000));
		empList.add(new Employee(2, "Sham", 40000));
		empList.add(new Employee(3, "Mukesh", 10000));

		System.out.println("Before Sorting --> ");
		for (Employee e : empList)
			System.out.println(e);

		// single-liner lambda expression
		// Collections.sort(empList, (o1, o2) -> o1.empid - o2.empid);
		Collections.sort(empList, (o1, o2) -> Double.compare(o2.salary, o1.salary));

		System.out.println();
		System.out.println("After Sorting --> ");
		for (Employee e : empList)
			System.out.println(e);
	}

}
