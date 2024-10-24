package com.sunbeam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program05 {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(5, "Mukesh", 30000));
		empList.add(new Employee(2, "Sham", 50000));
		empList.add(new Employee(1, "Anil", 40000));
		empList.add(new Employee(4, "Suresh", 10000));
		empList.add(new Employee(3, "Ramesh", 20000));
		
		
		
		System.out.println("Before Sorting -> ");
		for (Employee employee : empList)
			System.out.println(employee);

		// sort on the natural ordering of the employees
		// Collections.sort(empList);

		class EmpSalaryComparator implements Comparator<Employee> {
			boolean ascendingOrder = true;

			public EmpSalaryComparator() {
			}

			public EmpSalaryComparator(boolean ascendingOrder) {
				this.ascendingOrder = ascendingOrder;
			}

			@Override
			public int compare(Employee o1, Employee o2) {
				if (ascendingOrder)
					return Double.compare(o1.salary, o2.salary);
				return Double.compare(o2.salary, o1.salary);
			}
		}

		EmpSalaryComparator empSalComp = new EmpSalaryComparator();
		// Collections.sort(empList, empSalComp);

		System.out.println();
		System.out.println("After Sorting -> ");
		for (Employee employee : empList)
			System.out.println(employee);

	}

}
