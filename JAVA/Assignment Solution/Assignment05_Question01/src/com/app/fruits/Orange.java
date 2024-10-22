package com.app.fruits;

import java.util.Scanner;

public class Orange extends Fruit {

	{		
		name="Orange";
	}
	
	public void acceptData(Scanner sc) {
		System.out.println("Enter Color of Orange");
		color=sc.next();
		System.out.println("Enter weight of Orange");
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
		return "Sour";
	}
	
	@Override
	public String toString() {
		return "Orange [Name=" + name + ", Color=" + color + ", Weight=" + weight + ", Is fresh=" + isFresh + "]";
	}
	
}
