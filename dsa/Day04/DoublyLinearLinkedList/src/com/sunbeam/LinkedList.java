package com.sunbeam;

public class LinkedList {
	static class Node{
		private char data;
		private Node next, prev;
		public Node(char value) {
			data = value;
			next = prev = null;
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
		//return size == 0;
	}
	
	public void addFirst(char value) {
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(isEmpty())
			head = tail = nn;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add newnode into prev of first node
			head.prev = nn;
			//c. move head on newnode
			head = nn;
		}
		size++;
	}
	
	public void addLast(char value) {
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(isEmpty())
			head = tail = nn;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			nn.prev = tail;
			//b. add newnode into next of last node
			tail.next = nn;
			//c. move tail on newnode
			tail = nn;
		}
		size++;
	}
	
	public void addPosition(char value, int pos) {
		//0. validate positions
		if(pos < 1 || pos > size + 1)
			return;
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(isEmpty())
			head = tail = nn;
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
			//a. traverse till pos - 1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos node into next of nn
			nn.next = trav.next;
			//c. add pos-1 node into prev of nn
			nn.prev = trav;
			//d. add nn into next of pos-1 node
			trav.next = nn;
			//e. add nn into prev of pos node
			nn.next.prev = nn;
		}
		size++;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list is single node
		else if(size == 1)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add null into prev of second node
			head.next.prev = null;
			//b. move head on second node
			head = head.next;
		}
		size--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list is single node
		else if(size == 1)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add null into next of second last node
			tail.prev.next = null;
			//b. move tail on second last node
			tail = tail.prev;
		}
		size--;
	}
	
	public void deletePosition(int pos) {
		//0. 
		if(pos < 1 || pos > size)
			return;
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head.next == null)
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
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i++)
				trav = trav.next;
			//b. add pos+1 node into next of pos-1 node
			trav.prev.next = trav.next;
			//c. add pos-1 node into prev of pos+1 node
			trav.next.prev = trav.prev;
		}
		size--;
	}
	
	public void fDisplay() {
		//1. create trav & start at head
		Node trav = head;
		//2. repeat till last node
		System.out.print("Forward List : ");
		while(trav != null) {
			//3. visit / print current node
			System.out.print(" " + trav.data);
			//4. go on next node
			trav = trav.next;
		}
		System.out.println();
	}
	
	public void bDisplay() {
		//1. create trav & start at tail
		Node trav = tail;
		//2. repeat till first node
		System.out.print("Backword List : ");
		while(trav != null) {
			//3. visit / print current node
			System.out.print(" " + trav.data);
			//4. go on prev node
			trav = trav.prev;
		}
		System.out.println();
	}
	
	public int size() {
		return size;
	}
	
	public void deleteAll() {
		head = tail = null;
		size = 0;
	}
	
}












