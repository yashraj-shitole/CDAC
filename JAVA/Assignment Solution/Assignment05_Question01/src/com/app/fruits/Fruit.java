package com.app.fruits;

import java.util.*;

public abstract class Fruit {

	protected String name;
	protected String color;
	protected double weight;
	protected boolean isFresh=true;
	
	
	//abstract method to accept data
	public abstract void acceptData(Scanner sc);
	
	//abstract method to display data
	public abstract void displayData();
	
	public abstract String taste();
	
	//getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public boolean isFresh() {
		return isFresh;
	}
	public void setFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}

	@Override
	public String toString() {
		return "Fruit [Name=" + name + ", Color=" + color + ", Weight=" + weight + ", Is fresh=" + isFresh + "]";
	}
	
	
	
	
	
	
}
