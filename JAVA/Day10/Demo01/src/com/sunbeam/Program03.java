package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Program03 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(10);
		c1.add(20);
		c1.add(30);
		c1.add(40);
		c1.add(50);

		// fail-fast Iterators
		Iterator<Integer> itr = c1.iterator();
		while (itr.hasNext()) {
			Integer i1 = itr.next();
			if (i1 == 30)
				c1.add(60);
			System.out.println(i1);
		}

	}

}
