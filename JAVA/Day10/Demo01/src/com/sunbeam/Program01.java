package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;

public class Program01 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		// Collection<Integer> c1 = new LinkedList<Integer>();
		// Collection<Integer> c1 = new LinkedHashSet<Integer>();
		c1.add(10);// to add elements in the given collection
		c1.add(20);
		c1.add(30);
		c1.add(40);
		c1.add(50);

		// c1.clear(); // to remove all elements from the given collection

		System.out.println("Total elements = " + c1.size());

		System.out.println("Element found = " + c1.contains(30));
		System.out.println("Element found = " + c1.contains(60));

		System.out.println("Is empty = " + c1.isEmpty());

		c1.remove(10);
		System.out.println("Total elements = " + c1.size());

		for (Integer ele : c1)
			System.out.println(ele);
	}

}
