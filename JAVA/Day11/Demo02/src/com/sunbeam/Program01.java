package com.sunbeam;

import java.util.ArrayDeque;
import java.util.Queue;

public class Program01 {

	public static void main(String[] args) {
		Queue<Integer> q1 = new ArrayDeque<Integer>();
		q1.add(10);
		q1.add(20);
		q1.offer(30);

		System.out.println("Element at front = " + q1.element());
		System.out.println("Removed element = " + q1.remove());
		System.out.println("Removed element = " + q1.remove());
		System.out.println("Removed element = " + q1.remove());

		// System.out.println("Element at front = " + q1.element());
		// System.out.println("Removed element = " + q1.remove());

		System.out.println("Element at front = " + q1.peek());
		System.out.println("Removed element = " + q1.poll());
	}

}
