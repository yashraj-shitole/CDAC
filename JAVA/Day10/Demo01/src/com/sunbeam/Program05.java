package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;

public class Program05 {

	public static void main(String[] args) {
		Collection<Employee> c1 = new ArrayList<Employee>();
		c1.add(new Employee(1, "Anil", 10000));
		c1.add(new Employee(2, "Mukesh", 20000));
		c1.add(new Employee(3, "Ramesh", 30000));
		c1.add(new Employee(4, "Suresh", 40000));
		c1.add(new Employee(5, "Sham", 50000));

		for (Employee employee : c1)
			System.out.println(employee);

		Employee emp = new Employee();
		emp.empid = 3;
		System.out.println("Employee Found = " + c1.contains(emp));

		System.out.println("Employee removed = " + c1.remove(emp));

		System.out.println("Total elements = " + c1.size());

	}

}
