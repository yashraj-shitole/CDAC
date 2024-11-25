package com.sunbeam;

import java.util.Scanner;

public class Program03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Employee e3 = new Employee();
		e3.acceptEmployee(sc);

		Car c = new Car();
		c.acceptCar(sc);
		e3.setCar(c);

		e3.displayEmployee();

	}

}
