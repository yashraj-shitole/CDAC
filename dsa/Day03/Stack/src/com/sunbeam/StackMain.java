package com.sunbeam;

import java.util.Scanner;

public class StackMain {

	public static void main(String[] args) {
		
		Stack st = new Stack(4);
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("1. Push\n2. Pop\n3. Peek\n4. Exit");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				if(st.isFull())
					System.out.println("Stack is full");
				else {
					System.out.print("Enter value : ");
					int value = sc.nextInt();
					st.push(value);
				}
				break;
				
			case 2:
				if(st.isEmpty())
					System.out.println("Stack is empty");
				else
					System.out.println("Poped data : " + st.pop());
				break;
				
				
			case 3:
				if(st.isEmpty())
					System.out.println("Stack is empty");
				else
					System.out.println("Peeked data : " + st.peek());
				break;
			}
			
		}while(choice != 4);

	}

}
