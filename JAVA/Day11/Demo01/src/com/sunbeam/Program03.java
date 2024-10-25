package com.sunbeam;

import java.util.Stack;

public class Program03 {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		System.out.println("Is stacck empty = " + s1.isEmpty());
		s1.push(10);
		s1.push(20);
		s1.push(30);

		System.out.println("Element at peek = " + s1.peek());

		System.out.println("Popped element =  " + s1.pop());
		System.out.println("After pop, Element at peek = " + s1.peek());

		System.out.println("Popped element =  " + s1.pop());
		System.out.println("After pop, Element at peek = " + s1.peek());
	}

}
