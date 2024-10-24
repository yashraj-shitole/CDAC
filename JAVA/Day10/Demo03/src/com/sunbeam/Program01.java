package com.sunbeam;

import java.util.ArrayList;

public class Program01 {

	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);
		l1.add(50);

		l1.iterator();
		l1.listIterator();
		l1.listIterator(l1.size());
	}

}
