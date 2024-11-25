package com.sunbeam;

import java.util.LinkedHashSet;
import java.util.Set;

public class Program01 {

	public static void main(String[] args) {
		Set<String> names = new LinkedHashSet<String>();
		// Set<String> names = new HashSet<String>();
		// Set<String> names = new TreeSet<String>();
		names.add("Anil");
		names.add("Mukesh");
		names.add("Ramesh");
		names.add(null);
		names.add("Mukesh"); // NOT Added
		names.add(null);// NOT Added

		for (String s : names)
			System.out.print(s + ",");
	}

}
