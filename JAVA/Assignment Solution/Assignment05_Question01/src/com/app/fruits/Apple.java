package com.app.fruits;

import java.util.Scanner;

public class Apple extends Fruit {

	{		
		name="Apple";
	}
	
	public void acceptData(Scanner sc) {
		System.out.println("Enter Color of Apple");
		color=sc.next();
		System.out.println("Enter weight of Apple");
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
		return "Sweet n Sour";
	}

	
	
	@Override
	public String toString() {
		return "Apple [Name=" + name + ", Color=" + color + ", Weight=" + weight + ", Is fresh=" + isFresh + "]";
	}
	
}
