package com.sunbeam;

public class DoublyLinearLinkedListMain {

	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		
		l.addFirst('N');
		l.addFirst('U');
		l.addFirst('S');
		
		l.addLast('B');
		l.addLast('E');
		l.addLast('A');
		l.addLast('M');
		
		l.addPosition('@', 4);
		
		//l.deleteFirst();
		//l.deleteLast();
		
		l.deletePosition(1000);
		
		l.fDisplay();
		l.bDisplay();
		System.out.println("size = " + l.size());

	}

}
