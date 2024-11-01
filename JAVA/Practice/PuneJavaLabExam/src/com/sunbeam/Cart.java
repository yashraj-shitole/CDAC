package com.sunbeam;

import java.util.*;

public class Cart {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		
		ArrayList<Customer> customerList=new ArrayList<>();
		
		
		int choice=1;
		
		while( choice !=0) {
			
			System.out.println(	"0. EXIT"  
								+ "1. Add Customer \n"
								+ "2. Update Customer Details (Take input from User. E.g. Name, Email) \n"
								+ "3. Sort Product by their Price and PurchaseDate \n"
								+ "4. Search Product by Name (If product not found then throw Custom Exception) \n"
								+ "5. Add Products in a Cart and Generate Bill");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch (swichCase.values()[choice]) {
			case exit:
				System.out.println("Thanks for using app...");
				break;
			
			case addCustomer:
				
				break;

			default:
				break;
			}
			
			
		}
		
		
	}

}



enum swichCase{
	exit,
	addCustomer,
	updateCustomer,
	sortProduct,
	searchProduct,
	addProduct
}
