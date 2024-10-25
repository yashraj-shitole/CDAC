package com.sunbeam.p1;

import java.util.HashSet;
import java.util.Set;

public class Program01 {

	public static void main(String[] args) {
		// Set<Employee> empList = new LinkedHashSet<Employee>();
		Set<Employee> empList = new HashSet<Employee>();
		empList.add(new Employee(5, "Mukesh", 20000));
		empList.add(new Employee(2, "Anil", 10000));
		empList.add(new Employee(1, "Sham", 40000));
		empList.add(new Employee(3, "Ramesh", 50000));
		empList.add(new Employee(4, "Suresh", 30000));
		empList.add(new Employee(4, "Suresh", 30000));

		for (Employee employee : empList)
			System.out.println(employee);
	}

}
