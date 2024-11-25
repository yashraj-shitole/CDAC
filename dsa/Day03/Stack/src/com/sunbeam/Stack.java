package com.sunbeam;

public class Stack {
	private int arr[];
	private int top;
	private final int SIZE;
	public Stack(int size) {
		SIZE = size;
		arr = new int[SIZE];
		top = -1;
	}

	public void push(int value) {
		//1. reposition top (inc)
		top++;
		//2. add value at top index
		arr[top] = value;
	}

	public int pop() {
		int temp = arr[top];
		//1. reposition top (dec)
		top--;
		return temp;
		
		//return arr[top--];
	}
	
	public int peek() {
		//1. read and return value of top index
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE-1;
	}
}











