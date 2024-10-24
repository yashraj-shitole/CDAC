package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program04 {

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Ramesh");
		nameList.add("Anil");
		nameList.add("Suresh");
		nameList.add("Mukesh");
		nameList.add("Sham");

		System.out.println("Before Sorting -> ");
		for (String s : nameList)
			System.out.println(s);

		// sorting done on natural ordering of the elements
		// Collections.sort(nameList);

		class NameComparator implements Comparator<String> {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		}
		NameComparator nameComp = new NameComparator();

		// sorting done on descending order of the elements
		Collections.sort(nameList, nameComp);

		System.out.println();
		System.out.println("After Sorting -> ");
		for (String s : nameList)
			System.out.println(s);

	}

}
