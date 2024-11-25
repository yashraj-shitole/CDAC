package com.sunbeam;

public class DequeMain {

	public static void main(String[] args) {
		
		Deque dq = new Deque();
		
		dq.pushRear('A');
		dq.pushRear('B');
		dq.pushRear('C');
		
		dq.pushFront('D');
		dq.pushFront('E');
		
		System.out.println("Peeked Data : " + dq.peekRear());
		dq.popRear();
		System.out.println("Peeked Data : " + dq.peekRear());

	}

}







