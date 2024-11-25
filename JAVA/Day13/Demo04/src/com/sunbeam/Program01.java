package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program01 {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		Collections.addAll(l1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//		for (int element : l1)
//			if (element % 2 == 0)
//				System.out.println(element);

		l1.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.println(e));

	}

}
