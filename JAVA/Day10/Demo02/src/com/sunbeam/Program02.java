package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

public class Program02 {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Anil", 10000));
		empList.add(new Employee(2, "Mukesh", 20000));
		empList.add(new Employee(3, "Ramesh", 30000));
		empList.add(new Employee(4, "Suresh", 40000));
		empList.add(new Employee(5, "Sham", 50000));

		for (Employee employee : empList)
			System.out.println(employee);

		Employee e = new Employee();
		e.empid = 4;
		System.out.println("Index of emp with id 4 = " + empList.indexOf(e));

		System.out.println("Element at index 2 = " + empList.get(2));

		System.out.println("Element removed from index 2 = " + empList.remove(2));
		System.out.println("Element removed = " + empList.remove(e));
	}

}
