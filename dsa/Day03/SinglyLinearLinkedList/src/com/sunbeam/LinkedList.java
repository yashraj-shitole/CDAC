package com.sunbeam;

public class LinkedList {
	static class Node{
		private int data;
		private Node next;
		public Node(int value) {
			data = value;
			next = null;
		}
	}
	
	private Node head;
	public LinkedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. add first node into next of newnode
		newnode.next = head;
		//3. move head on newnode
		head = newnode;
	}
	
	public void addLast(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty())
			head = newnode;
		//3. list is not emoty
		else {
			//a. traverse till last node
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			//b. add newnode into next of last node
			trav.next = newnode;
		}
	}
	
	public void addPosition(int value, int pos) {
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty())
			head = newnode;
		// special condition : pos <= 1
		else if(pos <= 1)
			addFirst(value);
		//3. if list is not empty
		else {
			//a. traverse till pos-1 node
			Node trav = head;
										// special condition : pos > count + 1
			for(int i = 1 ; i < pos - 1 && trav.next != null; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add newnode into next of pos-1 node
			trav.next = newnode;
		}
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list is not empty, move head on second node
		head = head.next;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head.next == null)
			head = null;
		//3. if has multiple nodes
		else {
			// traverse till second last node
			Node trav = head;
			while(trav.next.next != null)
				trav = trav.next;
			// 
			trav.next = null;
		}
	}
	
	public void deletePosition(int pos) {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == null)
			head = null;
		// special condition : pos <= 1
		else if(pos <= 1) {
			head = head.next;
		}
		//3. if list has multiple node
		else {
			//a. traverse till pos -1 node
			Node trav = head;
										// special condition : pos > count 
			for(int i = 1 ; i < pos - 1 && trav.next.next != null ; i++)
				trav = trav.next;
			//b. add pos + 1 node into next of pos - 1 node
			trav.next = trav.next.next;
		}
	}
	
	public void display() {
		Node trav = head;
		System.out.print("List : ");
		while(trav != null) {
			// print current node
			System.out.print(" " + trav.data);
			// go on next node
			trav = trav.next;
		}// repeat above two step for each node
		System.out.println();
	}
	
	public void deleteAll() {
		head = null;
	}
	
}






















