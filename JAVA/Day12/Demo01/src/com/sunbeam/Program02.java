package com.sunbeam;

import java.util.Map;
import java.util.TreeMap;

public class Program02 {

	public static void main(String[] args) {
		// Map<Integer, String> m1 = new HashMap<Integer, String>();
		// Map<Integer, String> m1 = new LinkedHashMap<Integer, String>();
		Map<Integer, String> m1 = new TreeMap<Integer, String>();
		m1.put(165, "Sham");
		m1.put(132, "Mukesh");
		m1.put(143, "Ramesh");
		m1.put(121, "Anil");
		m1.put(154, "Suresh");

		System.out.println(m1);
	}

}
