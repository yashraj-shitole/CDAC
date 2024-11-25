package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Program02 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(10);
		c1.add(20);
		c1.add(30);
		c1.add(40);
		c1.add(50);

		System.out.println("Using for-each -->");
		for (Integer ele : c1)
			System.out.println(ele);

		System.out.println("Using Iterator -->");
		Iterator<Integer> itr = c1.iterator();
		while (itr.hasNext()) {
			Integer i1 = itr.next();
			System.out.println(i1);
		}

		System.out.println("Using Iterator in for loop -->");
		for (Iterator<Integer> it = c1.iterator(); it.hasNext();) {
			Integer i1 = it.next();
			System.out.println(i1);
		}
	}

}
