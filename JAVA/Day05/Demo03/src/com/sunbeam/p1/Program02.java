package com.sunbeam.p1;

import java.util.Scanner;

public class Program02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee e1 = new Employee();
		e1.acceptEmployee(sc);
		e1.displayEmployee();
	}

}
