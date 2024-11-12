package com.sunbeam;

public class DoublyCircularLinkedListMain {

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		
		l1.addFirst(40);
		l1.addFirst(30);
		l1.addFirst(20);
		l1.addFirst(10);
		
		l1.addLast(50);
		l1.addLast(60);
		
		//l1.addPosition(100, 7);
		
		//l1.deleteFirst();
		//l1.deleteLast();
		
		l1.deletePosition(6);
		
		l1.fDisplay();
		l1.rDisplay();
		System.out.println("List size : " + l1.size());

	}

}





