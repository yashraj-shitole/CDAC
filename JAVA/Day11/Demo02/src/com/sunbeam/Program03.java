package com.sunbeam;

import java.util.ArrayDeque;
import java.util.Deque;

// Stack Behaviour using Dequeu
public class Program03 {

	public static void main(String[] args) {
		Deque<Integer> q1 = new ArrayDeque<Integer>();
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
