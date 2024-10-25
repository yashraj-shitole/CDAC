package com.sunbeam;

import java.util.ArrayDeque;
import java.util.Deque;

// Queue Behaviour using Dequeu
public class Program02 {

	public static void main(String[] args) {
		Deque<Integer> q1 = new ArrayDeque<Integer>();
		q1.addLast(10);
		q1.addLast(20);
		q1.addLast(30);
		q1.offerLast(40);

		System.out.println("Element at Front = " + q1.getFirst());
		System.out.println("Removed element = " + q1.removeFirst());

		System.out.println("Element at Front = " + q1.peekFirst());
		System.out.println("Removed element = " + q1.pollFirst());

	}

}
