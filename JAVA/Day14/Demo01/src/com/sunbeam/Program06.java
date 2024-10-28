package com.sunbeam;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Program06 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new HashSet<Integer>();

		Collections.addAll(c1, 1, 2, 3, 4, 5);

		// collect from the stream will collect the result in the given Collection
		// it requires an object of Collector
		List<Integer> l1 = c1.stream().collect(Collectors.toList());
	}

}
