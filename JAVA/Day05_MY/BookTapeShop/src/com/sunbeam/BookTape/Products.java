package com.sunbeam.BookTape;

import java.util.Scanner;


//Q1. A shop sells book or tapes. The Book class holds id, title, author, and price; whereas Tape class
//holds id, title, artist, and price. There is 5% discount on tapes, while 10% discount on books.
//Assuming that each user purchase 3 products (either book or tape), calculate final bill. The program
//should be menu driven and should not cause memory leakage.
//Hint - Create class Product and inherit into Book and Tape. Also create array like Product* arr[3]
	

public class Products {
	
	protected int id;
	protected String title;
	protected double price;
	static int idAuto=1;
	
	public Products() {
		
		
	}
	

	public void acceptData(Scanner sc) {
		System.out.print("Enter title: ");
		title=sc.next();
		System.out.print("Enter Price: ");
		price=sc.nextDouble();
		id=idAuto;
		idAuto++;
		
	}

	public void displayData() {
		System.out.println("Id: "+id);
		System.out.println("Title: "+title);
		System.out.println("Price: "+price);
	}
	

}
