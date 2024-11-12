package com.sunbeam;

public class LinkedList {
	static class Node{
		private int data;
		private Node next, prev;
		public Node(int value) {
			data = value;
			next = prev = null;
		}
	}
	
	private Node head;
	private int size;
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(int value) {
		//a. create node
		Node nn = new Node(value);
		//b. if list is empty
		if(head == null) {
			head = nn;
			nn.prev = nn.next = nn;
		}
		//c. if list is not empty
		else {
			//1. add first node into next of newnode
			nn.next = head;
			//2. add last node into prev of newnode
			nn.prev = head.prev;
			//3. add newnode into next of last node
			head.prev.next = nn;
			//4. add newnode into prev of first
			head.prev = nn;
			//5. move head on newnode
			head = nn;
		}
		size++;
	}
	
	public void addLast(int value) {
		//a. create node
		Node nn = new Node(value);
		//b. if list is empty
		if(head == null) {
			head = nn;
			nn.prev = nn.next = nn;
		}
		//c. if list is not empty
		else {
			//1. add first node into next of newnode
			nn.next = head;
			//2. add last node into prev of newnode
			nn.prev = head.prev;
			//3. add newnode into next of last node
			head.prev.next = nn;
			//4. add newnode into prev of first
			head.prev = nn;
		}
		size++;
	}
	
	public void addPosition(int value, int pos) {
		//0. if position is invalid
		if(pos < 1 || pos > size + 1)
			return;
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(head == null) {
			head = nn;
			nn.prev = nn.next = nn;
		}
		//3. if list is not empty
		else {
			Node before, after;
			if(pos == 1) {
				before = head;
				after = head.prev;
				head = nn;
			}else {
				Node trav = head;
				for(int i = 1 ; i < pos - 1 ; i++)
					trav = trav.next;
				after = trav;
				before = trav.next;
			}			
			nn.next = before;
			nn.prev = after;
			before.prev = nn;
			after.next = nn;
		}
		size++;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. add second node into next of last node
			head.prev.next = head.next;
			//b. add last node into prev of second node
			head.next.prev = head.prev;
			//c. move head on second node
			head = head.next;
		}
		size--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. add first node into next of second last node
			head.prev.prev.next = head;
			//b. add second last node into prev of first node
			head.prev = head.prev.prev;
		}
		size--;
	}
	
	public void deletePosition(int pos) {
		//1. if position is invalid
		if(pos < 1 || pos > size)
			return;
		//2. if list is empty
		else if(head == null)
			return;
		//3. if list has single node
		else if(head.next == head)
			head = null;
		//4. if list has multiple nodes
		else {
			Node before, after;
			if(pos == 1) {
				before = head.next;
				after = head.prev;
				head = head.next;
			}else {
				Node trav = head;
				for(int i = 1 ; i < pos ; i++)
					trav = trav.next;
				after = trav.prev;
				before = trav.next;
			}
			after.next = before;
			before.prev = after;
		}
		size--;
	}
	
	public void fDisplay() {
		//0. if list is empty
		if(head == null)
			return;
		//1. create trav and start at first node
		Node trav = head;
		System.out.print("Forward List : ");
		do {
			//2. print current node data
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head); //4. repeat till last node
		System.out.println();
	}
	
	public void rDisplay() {
		//0. if list is empty
		if(head == null)
			return;
		//1. create trav and start at last node
		Node trav = head.prev;
		System.out.print("Reverse List : ");
		do {
			//2. print current node data
			System.out.print(" " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}while(trav != head.prev); //4. repeat till first node
		System.out.println();
	}
	
	public void deleteAll() {
		head = null;
		size = 0;
	}
	
}









