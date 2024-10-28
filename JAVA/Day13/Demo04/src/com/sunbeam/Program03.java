package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program03 {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		Collections.addAll(l1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// l1.stream().limit(5).forEach(System.out::println);

		l1.stream().skip(3).limit(5).forEach(System.out::println);

	}

}
