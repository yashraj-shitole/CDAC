package com.sunbeam.p3;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Program01 {

	public static void main(String[] args) {
		class EmpSalComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee o1, Employee o2) {
				return Double.compare(o2.salary, o1.salary);
			}
		}
		EmpSalComparator empSalComp = new EmpSalComparator();

		Set<Employee> empList = new TreeSet<Employee>(empSalComp);
		empList.add(new Employee(5, "Mukesh", 20000));
		empList.add(new Employee(2, "Anil", 10000));
		empList.add(new Employee(1, "Sham", 40000));
		empList.add(new Employee(3, "Ramesh", 50000));
		empList.add(new Employee(4, "Suresh", 30000));
		empList.add(new Employee(4, "Suresh", 35000));

		for (Employee employee : empList)
			System.out.println(employee);

		Employee e = new Employee();
		e.id = 4;
		e.salary = 30000;
		System.out.println("Element found = " + empList.contains(e));

	}

}
