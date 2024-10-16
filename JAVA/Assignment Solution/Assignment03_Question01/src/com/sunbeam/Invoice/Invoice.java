package com.sunbeam.Invoice;

import java.util.Scanner;

//Q1. Create a class called Invoice that a hardware store might use to represent an invoice for an item
//sold at the store. An Invoice should include four pieces of information as fields—a part number
//(type String), a part description (type String), a quantity of the item being purchased (type int) and a
//price per item (double). Your class should have a constructor
//that initializes the four instance variables. Provide a set and a get method for each instance variable.
//calculates the invoice amount (i.e. multiplies the quantity by the price per item), then returns the
//amount as a double value.
//If the quantity is not positive, it should be set to 0.
//If the price per item is not positive, it should be set to 0.0.
//Write a test application named InvoiceTest that demonstrate class Invoice’s capabilities.


public class Invoice {

	private String partNumber;
	private String partDescription;
	private int partQuantity;
	private double partPrice;
	double partAmount;
	
	public Invoice() {
		partNumber="No Data Available";
		partDescription="No Data Available";
		partQuantity=0;
		partPrice=0.0;
		partAmount=0.0;
	}
	
	
	public void acceptPart() {
		Scanner sc= new Scanner(System.in);
		
		//set part number
		System.out.print("Enter part number: ");
		this.partNumber=sc.next();
		
		//set part description
		System.out.print("Enter part description: ");
		this.partDescription=sc.next();
		
		
		//set quantity
		System.out.print("Enter part quantity: ");
		int inputPartQuantity=sc.nextInt();
		if (inputPartQuantity<0) { //to check quantity is positive
			System.err.println("Quantity cant be negative");
			System.err.println("Quantity set to 0");
			this.partQuantity=0;
		}else {
			this.partQuantity=inputPartQuantity;
		}
		
		
		//set price
		System.out.print("Enter part price: ");
		int inputPartPrice=sc.nextInt();
		if (inputPartPrice<0) { //to check price is positive
			System.err.println("Price cant be negative");
			System.err.println("Price set to 0");
			this.partPrice=0;
		}
		else {
			this.partPrice=inputPartPrice;
		}
		
		//set part amount by multiplying part price and part quantity
		this.partAmount=partPrice*partQuantity;
		
	}

	public void displayPart(){
		
		System.out.println(partNumber+"\t\t"+partDescription+"\t\t"+partQuantity+"\t\t"+partPrice+"\t\t"+partAmount);
		
	}
	
	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getPartQuantity() {
		return partQuantity;
	}

	public void setPartQuantity(int partQuantity) {
		if (partQuantity<0) {
			this.partQuantity=0;
		}else {
			this.partQuantity=partQuantity;
		}
	}

	public double getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(double partPrice) {
		if (partPrice<0) {
			this.partPrice=0;
		}
		else {
			this.partPrice=partPrice;
		};
	}

	public double getPartAmount() {
				
		return partAmount;
	}
	
	
}
