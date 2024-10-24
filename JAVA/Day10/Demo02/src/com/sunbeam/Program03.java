package com.sunbeam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Program03 {

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Anil");
		nameList.add("Ramesh");
		nameList.add("Mukesh");
		nameList.add("Suresh");

		ListIterator<String> listItr = nameList.listIterator(nameList.size());
		while (listItr.hasPrevious()) {
			String name = listItr.previous();
			System.out.println(name);
		}
	}

	public static void main2(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Anil");
		nameList.add("Ramesh");
		nameList.add("Mukesh");
		nameList.add("Suresh");

		ListIterator<String> itr = nameList.listIterator(nameList.size()); // to go reverse use parameter as size of array\
		while (itr.hasPrevious()) {
			String name = itr.previous();
			System.out.println(name);
		}

	}

	public static void main1(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Anil");
		nameList.add("Ramesh");
		nameList.add("Mukesh");
		nameList.add("Suresh");

		Iterator<String> itr = nameList.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}

}
