package com.sunbeam;

import java.util.LinkedHashMap;
import java.util.Map;

public class Program03 {

	public static void main(String[] args) {
		Map<Integer, String> m1 = new LinkedHashMap<Integer, String>();
		m1.put(165, "Sham");
		m1.put(132, "Mukesh");
		m1.put(143, "Ramesh");
		m1.put(121, "Anil");
		m1.put(154, "Suresh");
		m1.put(154, "SURESH"); // value is replaced
		m1.put(null, "Ram");// OK
		m1.put(null, "Rahul");// value is replaced
		m1.put(176, "Ramesh");// OK duplicate values are allowed
		m1.put(187, null); // OK
		m1.put(198, null);// OK

		System.out.println(m1);

		System.out.println("Key found = " + m1.containsKey(121));
		System.out.println("Value found = " + m1.containsValue("Ramesh"));

		System.out.println("Value = " + m1.get(132));
	}

}
