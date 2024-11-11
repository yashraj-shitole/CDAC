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

	private Node head, tail;
	private int size;
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty()) {
			head = tail = newnode;
			tail.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move head on newnode
			head = newnode;
		}
		size++;
	}
	
	public void addLast(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty()) {
			head = tail = newnode;
			tail.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
		size++;
	}
	
	public void addPosition(int value, int pos) {
		//0. validate the position
		if(pos < 1 || pos > size + 1)
			return;
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty
		if(size == 0) {
			head = tail = newnode;
			tail.next = head;
		}
		else if(pos == 1) {
			addFirst(value);
			return;
		}
		else if(pos == size + 1) {
			addLast(value);
			return;
		}
		//3. if list is not empty
		else {
			//a. traverse till pos-1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add newnode into next of pos - 1 node
			trav.next = newnode;
		}
		size++;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(size == 0)
			return;
		//2. if list has single node
		else if(size == 1)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add second node into next of last node
			tail.next = head.next;
			//b. move head on second node
			head = head.next;
		}
		size--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(size == 0) 
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next.next != head)
				trav = trav.next;
			//b. add first node into next of second last node
			trav.next = head;
			//c. move tail on second last node
			tail = trav;
		}
		size--;
	}
	
	public void deletePosition(int pos) {
		//0. validate the positions
		if(pos < 1 || pos > size)
			return;
		//1. if list is empty
		if(head == null && tail == null)
			return;
		//2. if last has single node
		else if(head.next == head)
			head = tail = null;
		else if(pos == 1) {
			deleteFirst();
			return;
		}
		else if(pos == size) {
			deleteLast();
			return;
		}
		//3. if list has multiple nodes
		else {
			//a. traverse till pos -1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos+1 node into next of pos-1 node
			trav.next = trav.next.next;
		}
		size--;
	}
	
	public void display() {
		//0. if list is empty
		if(isEmpty())
			return;
		//1. create trav and start at head
		Node trav = head;
		System.out.print("List : ");
		do {
			//2. visit current node
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head);	//4. repeat till last node
		System.out.println();
		System.out.println("last node = " + tail.data);
	}
	
	public void deleteAll() {
		head = tail = null;
		size = 0;
	}
	
	
}













