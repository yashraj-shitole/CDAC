package com.sunbeam.BookTape;

import java.util.Scanner;

//Q1. A shop sells book or tapes. The Book class holds id, title, author, and price; whereas Tape class
//holds id, title, artist, and price. There is 5% discount on tapes, while 10% discount on books.
//Assuming that each user purchase 3 products (either book or tape), calculate final bill. The program
//should be menu driven and should not cause memory leakage.
//Hint - Create class Product and inherit into Book and Tape. Also create array like Product* arr[3]
		
public class Tape extends Products {

	private String artist;
	
	
	
	public Tape() {
		new Products();
		artist="No Data Available";
	}
	
	@Override
	public void acceptData(Scanner sc) {
		System.out.print("Enter title of Tape: ");
		title=sc.next();
		System.out.println("Enter artist of Tape: ");
		artist=sc.next();
		System.out.println("Enter price of Tape: ");
		price=sc.nextDouble();
	}
	
	@Override 
	public void displayData() {
		System.out.println("Tape id: "+id);
		System.out.print("Tape title: "+title);
		System.out.println("Tape author: "+artist);
		System.out.println("Tape price: "+price);
	}
	
}
