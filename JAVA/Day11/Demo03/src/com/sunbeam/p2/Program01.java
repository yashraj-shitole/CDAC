package com.sunbeam.p2;

import java.util.Set;
import java.util.TreeSet;

public class Program01 {

	public static void main(String[] args) {
		Set<Employee> empList = new TreeSet<Employee>();
		empList.add(new Employee(5, "Mukesh", 20000));
		empList.add(new Employee(2, "Anil", 10000));
		empList.add(new Employee(1, "Sham", 40000));
		empList.add(new Employee(3, "Ramesh", 50000));
		empList.add(new Employee(4, "Suresh", 30000));
		empList.add(new Employee(4, "Suresh", 30000));

		for (Employee employee : empList)
			System.out.println(employee);

		Employee e = new Employee();
		e.id = 3;
		System.out.println("Element found = " + empList.contains(e));
	}

}
