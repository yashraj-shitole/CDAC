package com.sunbeam;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//class Pair<K, V> {
//	K key;
//	V value;
//}
//Collection<Pair<Integer, String>> c1;

public class Program01 {

	public static void main(String[] args) {
		Map<Integer, String> m1 = new LinkedHashMap<Integer, String>();
		m1.put(165, "Sham");
		m1.put(132, "Mukesh");
		m1.put(143, "Ramesh");
		m1.put(121, "Anil");
		m1.put(154, "Suresh");

		Set<Integer> keys = m1.keySet();
		for (Integer i : keys)
			System.out.print(i + ", ");
		System.out.println();

		Collection<String> values = m1.values();
		for (String s : values)
			System.out.print(s + ", ");
		System.out.println();

		Set<Map.Entry<Integer, String>> entries = m1.entrySet();
		for (Map.Entry<Integer, String> ele : entries)
			System.out.println(ele.getKey() + " - " + ele.getValue());

		System.out.println(m1);
	}

}
