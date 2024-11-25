package com.sunbeam;

import java.util.Enumeration;
import java.util.Vector;

public class Program02 {

	public static void main(String[] args) {
		Vector<Integer> v1 = new Vector<Integer>();
		v1.add(10);
		v1.addElement(20);
		v1.add(30);
		v1.addElement(40);

		// for-each
		// TO-DO

		// Iterator
		// TO-DO

		// for-loop
		// TO-DO

		// Enumeration
		Enumeration<Integer> en = v1.elements();
		while (en.hasMoreElements()) {
			Integer i1 = en.nextElement();
			System.out.println(i1);
		}

	}

}
