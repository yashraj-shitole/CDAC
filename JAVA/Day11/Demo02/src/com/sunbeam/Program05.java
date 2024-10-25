package com.sunbeam;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Program05 {

	public static void main(String[] args) {
		// Deque<Integer> q1 = new LinkedList<Integer>();
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);

		System.out.println("List in forward -> ");
		for (Integer i1 : l1)
			System.out.println(i1);

		System.out.println("List in Backward -> ");
		ListIterator<Integer> itr = l1.listIterator(l1.size());
		while (itr.hasPrevious()) {
			Integer i1 = itr.previous();
			System.out.println(i1);
		}
	}

}
