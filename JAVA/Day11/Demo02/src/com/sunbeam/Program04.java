package com.sunbeam;

import java.util.Deque;
import java.util.LinkedList;

// Stack Behaviour using Dequeu
public class Program04 {

	public static void main(String[] args) {
		Deque<Integer> q1 = new LinkedList<Integer>();
		// List<Integer> l1 = new LinkedList<Integer>();
		q1.addLast(10);
		q1.addLast(20);
		q1.addLast(30);
		q1.offerLast(40);

		System.out.println("Element at top = " + q1.getLast());
		System.out.println("Popped element = " + q1.removeLast());

		System.out.println("Element at top = " + q1.peekLast());
		System.out.println("Popped element  = " + q1.pollLast());

	}

}
