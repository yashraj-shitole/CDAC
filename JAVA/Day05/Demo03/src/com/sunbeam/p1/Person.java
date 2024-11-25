package com.sunbeam.p1;

import java.util.Scanner;

public class Person {
	String name;

	public Person() {
		System.out.println("Person()");
	}

	public Person(String name) {
		System.out.println("Person(String)");
		this.name = name;
	}

	public void acceptPerson(Scanner sc) {
		System.out.print("Enter name - ");
		name = sc.next();
	}

	public void displayPerson() {
		System.out.println("Name - " + name);
	}

}
