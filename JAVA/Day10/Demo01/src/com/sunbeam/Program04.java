package com.sunbeam;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Program04 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new CopyOnWriteArrayList<Integer>();
		c1.add(10);
		c1.add(20);
		c1.add(30);
		c1.add(40);
		c1.add(50);

		// fail-safe Iterators
		Iterator<Integer> itr = c1.iterator();
		while (itr.hasNext()) {
			Integer i1 = itr.next();
			if (i1 == 30)
				c1.add(60);
			System.out.println(i1);
		}

		System.out.println("Total elements = " + c1.size());

	}

}
