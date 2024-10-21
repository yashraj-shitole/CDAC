package com.sunbeam.Main;

import java.util.*;

import com.sunbeam.BookTape.*;

//Q1. A shop sells book or tapes. The Book class holds id, title, author, and price; whereas Tape class
//holds id, title, artist, and price. There is 5% discount on tapes, while 10% discount on books.
//Assuming that each user purchase 3 products (either book or tape), calculate final bill. The program
//should be menu driven and should not cause memory leakage.
//Hint - Create class Product and inherit into Book and Tape. Also create array like Product* arr[3]
	
public class BookTapeMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Products p=new Products();
		Products[] pArr=new Products[10];
		
		int choice=1;
		int count=0;
		while(choice!=0) {
			
			//menu
			System.out.println("1. To add Tape\n2. To add Book\n3. Display Products\n0. EXIT");
		System.out.print("Enter choice: ");
		choice=sc.nextInt();
			
			switch(choice) {
			case 1:{
					pArr[count]=(Products) new Tape();
					System.out.println("Enter Tape details");
					pArr[count].acceptData(sc);
					count++;
				break;
			}
			case 2:{
					pArr[count]=(Products) new Book();
					System.out.println("Enter Book details");
					pArr[count].acceptData(sc);
					count++;
					break;
			}
			case 3:{
					for(int i=0;i<count;i++) {
						pArr[i].displayData();
					}
				break;
			}
			case 0:{
				System.out.println("Thank you for using app...");
				choice=0;
				break;
			}
			}
		}
		
	}


}
