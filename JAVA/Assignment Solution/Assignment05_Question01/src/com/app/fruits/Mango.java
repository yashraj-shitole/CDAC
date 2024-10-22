package com.app.fruits;

import java.util.Scanner;

public class Mango extends Fruit {

	{		
		name="Mango";
	}
	
	public void acceptData(Scanner sc) {
		System.out.println("Enter Color of Mango");
		color=sc.next();
		System.out.println("Enter weight of Mango");
		weight=sc.nextDouble();
	}
	
	public void displayData() {
		System.out.println("Name= " + name +
				"\nColor= " + color + 
				"\nWeight= " + weight + 
				"\nIs fresh=" + isFresh
				);
	}
	
	public String taste() {
		return "Sweet";
	}
	
	@Override
	public String toString() {
		return "Mango [Name=" + name + ", Color=" + color + ", Weight=" + weight + ", Is fresh=" + isFresh + "]";
	}
	
}
