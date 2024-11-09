package com.sunbeam;

public class LinearQueue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	public LinearQueue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}
	
	public void push(int value) {
		//1. reposition rear (inc)
		rear++;
		//2. add value at rear index
		arr[rear] = value;
	}
	
	public int pop() {
		int temp = arr[front + 1];
		//1. reposition front (inc)
		front++;
		return temp;
	}
	
	public int peek() {
		//1. read/return data of front+1 index
		return arr[front + 1];
	}

	public boolean isFull() {
		return rear == SIZE-1;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}	
}













