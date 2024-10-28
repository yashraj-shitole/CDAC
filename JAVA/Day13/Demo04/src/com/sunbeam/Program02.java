package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program02 {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		Collections.addAll(l1, 5, 7, 3, 4, 9, 1, 3, 8, 5, 2, 7, 8, 4);

		l1.stream().distinct().forEach(System.out::println);

		long count = l1.stream().distinct().count();
		System.out.println("Count of distinct elements = " + count);
	}

}
