package com.app.fruitbasket;

import java.util.Iterator;
import java.util.Scanner;

import com.app.fruits.*;


public class FruitBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int basketCount=0; //to track number of items added to basket
		int choice=1;  //to get the menu item choice
		Fruit[] fruitBasket=new Fruit[50];
		
//		fruitBasket[0]=new Apple();
//		fruitBasket[0].acceptData(sc);
//		fruitBasket[0].displayData();

		
		while (choice !=0) {
			
			System.out.println("0. EXIT\n"
					+ "1. Add Mango\n"
					+ "2. Add Orange\n"
					+ "3. Add Apple\n4. Display Names of all fruits in basket\n"
					+ "5. Display Name, Color, Weight, Taste of all fresh fruits in basket\n"
					+ "6. Display taste of all stale fruits\n"
					+ "7. Mark a fruits as stale\n"
					+ "8. Mark all sour fruits stale");
			
			choice =sc.nextInt();
			
			switch (choice) {
			case 0:{
				System.out.println("Thank you for using app...");
				break;
			}
			case 1:{
				fruitBasket[basketCount]=new Mango();
				fruitBasket[basketCount].acceptData(sc);
				
				System.out.println("Mango Added");
				basketCount++;
				break;
			}
			case 2:{
				fruitBasket[basketCount]=new Orange();
				fruitBasket[basketCount].acceptData(sc);
				System.out.println("Orange Added");
				basketCount++;
				break;
			}
			case 3:{
				fruitBasket[basketCount]=new Apple();
				fruitBasket[basketCount].acceptData(sc);
				System.out.println("Apple Added");
				basketCount++;
				break;
			}
			case 4:{
				for (int i = 0;i<basketCount;i++) {
					fruitBasket[i].displayData();
					System.out.println();
				}	
				break;
			}
			case 5:{
				for(int i=0;i<basketCount;i++) {
					if(fruitBasket[i].isFresh()) {
						System.out.println("Name= "+fruitBasket[i].getName()
								+"\nColor= "+fruitBasket[i].getColor()
								+"\nWeight= "+fruitBasket[i].getWeight()
								+"\nTaste= "+fruitBasket[i].taste());
						
						System.out.println();
					}
				}
				break;
			}
			case 6:{
				
				for (int i = 0; i < basketCount; i++) {
					if (fruitBasket[i].isFresh()==false) {
						System.out.println("Taste of "+fruitBasket[i].getName()
								+" is "+fruitBasket[i].taste());
					}
				}
				break;
			}	
			case 7:{
				int index;
				System.out.println("Enter index to mark fruit as stale");
				index=sc.nextInt();
				if (index<basketCount) {
					fruitBasket[index].setFresh(false);
				}
				else {
					System.out.println("Fruit does not exist at index "+index);
				}
				break;
			}
				
			case 8:{
				System.out.println("Are you sure to mark all fruits as stale? y/n");
				String sure=sc.next();
				
				
				if (sure=="y" || sure=="Y") {
					for (int i = 0; i < basketCount; i++) {
						
						if(fruitBasket[i].taste()=="Sour") {
							fruitBasket[i].setFresh(false);
							fruitBasket[i].displayData();
						}
					}
				}
				else {
					break;
				}
				break;
			}
			
			case 9:{
				
				fruitBasket[0]=new Apple();
				fruitBasket[0].setColor("Red");
				fruitBasket[0].setWeight(21);

				fruitBasket[1]=new Orange();
				fruitBasket[1].setColor("Orange");
				fruitBasket[1].setWeight(11);
				
				fruitBasket[2]=new Mango();
				fruitBasket[2].setColor("Yellow");
				fruitBasket[2].setWeight(32);
				
				fruitBasket[3]=new Orange();
				fruitBasket[3].setColor("Green");
				fruitBasket[3].setWeight(21);
				
				basketCount=4;
				
				
				break;
			}

			default:{
				System.out.println("WRONG CHOICE");
				break;
			}
			}
			
		}
		
		
	}

}
