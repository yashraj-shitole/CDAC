package com.sunbeam;

import java.util.stream.Stream;

public class Program01 {

	public static void main(String[] args) {
		// way-1
		// Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 10).forEach(System.out::println);

		// way-2
		// Stream.generate(() -> Math.random() *
		// 100).limit(10).forEach(System.out::println);

		// way-3
		Stream.iterate(1, (i) -> i + 1).limit(10).forEach(System.out::println);

	}

}
