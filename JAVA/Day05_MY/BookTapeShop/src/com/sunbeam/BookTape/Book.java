package com.sunbeam.BookTape;

import java.util.Scanner;

//Q1. A shop sells book or tapes. The Book class holds id, title, author, and price; whereas Tape class
//holds id, title, artist, and price. There is 5% discount on tapes, while 10% discount on books.
//Assuming that each user purchase 3 products (either book or tape), calculate final bill. The program
//should be menu driven and should not cause memory leakage.
//Hint - Create class Product and inherit into Book and Tape. Also create array like Product* arr[3]
		

public class Book extends Products {

	private String author;
	
	
	@Override
	public void acceptData(Scanner sc) {
		super.acceptData(sc);
		System.out.print("Enter author: ");
		author=sc.next();
	}
	
	@Override
	public void displayData() {
		super.displayData();
		System.out.println("Author: "+author);
		
	}
}
