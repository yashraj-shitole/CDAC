package com.sunbeam.p3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class EmpNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.name.compareTo(o2.name);
	}
}

class EmpSalaryComparatorAsc implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return Double.compare(o1.salary, o2.salary);
	}
}

class EmpSalaryComparatorDesc implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return Double.compare(o2.salary, o1.salary);
	}
}

public class Program01 {

	public static int menu(Scanner sc) {
		System.out.println("0. EXIT");
		System.out.println("1. Display All Employees ");
		System.out.println("2. Display Employees Sorted on empid");
		System.out.println("3. Display Employees Sorted on name");
		System.out.println("4. Display Employees Sorted on salary");
		System.out.println("5. Display Employees Sorted on salary in Desc");
		return sc.nextInt();
	}

	public static void displayAllEmployees(Employee[] arr) {
		System.out.println("*************************");
		for (Employee employee : arr)
			System.out.println(employee);
		System.out.println("*************************");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee[] arr = new Employee[5];
		Comparator<Employee> comparator;
		arr[0] = new Employee(5, "Mukesh", 20000);
		arr[1] = new Employee(1, "Anil", 50000);
		arr[2] = new Employee(4, "Suresh", 10000);
		arr[3] = new Employee(3, "Ramesh", 30000);
		arr[4] = new Employee(2, "Sham", 40000);
		int choice;
		while ((choice = menu(sc)) != 0) {
			switch (choice) {
			case 1:
				displayAllEmployees(arr);
				break;
			case 2:
				Arrays.sort(arr);
				displayAllEmployees(arr);
				break;
			case 3:
				comparator = new EmpNameComparator();
				Arrays.sort(arr, comparator);
				displayAllEmployees(arr);
				break;
			case 4:
				comparator = new EmpSalaryComparatorAsc();
				Arrays.sort(arr, comparator);
				displayAllEmployees(arr);
				break;
			case 5:
				comparator = new EmpSalaryComparatorDesc();
				Arrays.sort(arr, comparator);
				displayAllEmployees(arr);
				break;

			default:
				System.out.println("Wrong choice...");
				break;
			}
		}

	}

}
