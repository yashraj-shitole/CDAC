package com.sunbeam.p2;

import java.util.Scanner;

public class Program02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p = new Employee(); // upcasting
		p.accept(sc);
		p.display();

		Employee e = (Employee) p; // Downcasting
		e.calculateTax();

	}

}
