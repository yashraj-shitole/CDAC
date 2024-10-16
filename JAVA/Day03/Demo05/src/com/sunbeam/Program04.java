package com.sunbeam;

public class Program04 {

	public static void main(String[] args) {
		Employee[] arr = new Employee[5];
		arr[0] = new Employee(1, "Anil", 10000);
		arr[1] = new Employee(2, "Mukesh", 20000);
		arr[2] = new Employee(3, "Ramesh", 30000);
		arr[3] = new Employee(4, "Suresh", 40000);
		arr[4] = new Employee(5, "Sham", 50000);

		// for-loop
		// for (int i = 0; i < arr.length; i++)
		// arr[i].display();

		// for-each
		// for (Employee e : arr)
		// e.salary = e.salary + 2000;

		// for-each
		for (Employee e : arr)
			e = new Employee();

		for (Employee e : arr)
			e.display();
	}
}
