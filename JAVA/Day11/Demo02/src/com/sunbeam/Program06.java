package com.sunbeam;

import java.util.PriorityQueue;
import java.util.Queue;

public class Program06 {

	public static void main(String[] args) {
		Queue<Integer> q1 = new PriorityQueue<Integer>();
		q1.add(30);
		q1.add(20);
		q1.add(10);
		q1.add(40);

		System.out.println("Element at front = " + q1.element());
		System.out.println("Element Removed = " + q1.remove());
		System.out.println("Element Removed = " + q1.remove());
		System.out.println("Element Removed = " + q1.remove());
		System.out.println("Element Removed = " + q1.remove());

	}

}
