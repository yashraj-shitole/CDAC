package com.sunbeam;

public class Deque {
	private LinkedList list;
	
	public Deque() {
		list = new LinkedList();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void pushRear(char ch) {
		list.addFirst(ch);
	}
	
	public void pushFront(char ch) {
		list.addLast(ch);
	}
	
	public void popRear() {
		list.deleteFirst();
	}
	
	
	public int peekRear() {
		//retrun ??
		return list.getHeadData();
	}
}











