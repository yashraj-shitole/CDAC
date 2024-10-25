package com.sunbeam;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Employee implements Comparable<Employee> {
	int id;
	String name;
	double salary;

	public Employee() {
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}

}

public class Program07 {

	public static void main(String[] args) {
		// Queue<Employee> q1 = new PriorityQueue<Employee>(); // natural ordering

		class EmpSalComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee o1, Employee o2) {
				return Double.compare(o2.salary, o1.salary);
			}
		}
		EmpSalComparator empSalComp = new EmpSalComparator();

		Queue<Employee> q1 = new PriorityQueue<Employee>(empSalComp);

		q1.add(new Employee(5, "Mukesh", 20000));
		q1.add(new Employee(2, "Anil", 10000));
		q1.add(new Employee(1, "Sham", 40000));
		q1.add(new Employee(3, "Ramesh", 50000));
		q1.add(new Employee(4, "Suresh", 30000));

		System.out.println("Element at front = " + q1.element());
		System.out.println("Element Removed = " + q1.remove());
		System.out.println("Element Removed = " + q1.remove());
	}

}
