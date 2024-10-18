package com.sunbeam.p3;

import java.util.Scanner;

public class Person {
	String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public void accept(Scanner sc) {
		System.out.print("Enter name - ");
		name = sc.next();
	}

	public void display() {
		System.out.println("Name - " + name);
	}

}
