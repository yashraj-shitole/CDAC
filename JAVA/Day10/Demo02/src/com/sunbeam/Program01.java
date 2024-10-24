package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

public class Program01 {

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Anil");
		nameList.add("Ramesh");
		nameList.add("Mukesh");
		nameList.add("Ramesh");

		nameList.add(1, "Suresh");

		for (int i = 0; i < nameList.size(); i++) {
			String name = nameList.get(i);
			System.out.print(name + ", ");
		}

		System.out.println();

		System.out.println("Element at index 2 = " + nameList.get(2));

		System.out.println("Index of Ramesh = " + nameList.indexOf("Ramesh"));
		System.out.println("Last Index of Ramesh = " + nameList.lastIndexOf("Ramesh"));

		System.out.println("Name found = " + nameList.contains("Mukesh"));
		System.out.println("Name Removed = " + nameList.remove("Mukesh"));
	}

}
