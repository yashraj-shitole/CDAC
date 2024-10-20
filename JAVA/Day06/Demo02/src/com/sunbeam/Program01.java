package com.sunbeam;

import java.util.Scanner;

public class Program01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Employee e1 = new Employee(1, "Anil", 10000);
		// e1.accept(sc);

		// Employee e1 = new Manager(1, "Anil", 10000, 2000);

		Employee e1 = new Salesman();

		e1.accept(sc);
		e1.display();
	}

}
