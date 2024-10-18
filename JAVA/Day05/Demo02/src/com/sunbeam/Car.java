package com.sunbeam;

import java.util.Scanner;

public class Car {
	String name;
	String number;

	public Car() {
	}

	public Car(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public void acceptCar(Scanner sc) {
		System.out.print("Enter the car name - ");
		name = sc.next();
		System.out.print("Enter the car number - ");
		number = sc.next();
	}

	public void displayCar() {
		System.out.println("Car name - " + name);
		System.out.println("Car number - " + number);
	}
}
