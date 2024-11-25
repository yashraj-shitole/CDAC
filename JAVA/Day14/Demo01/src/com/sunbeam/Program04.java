package com.sunbeam;

import java.util.stream.Stream;

public class Program04 {

	public static void main(String[] args) {
		Stream.of(9, 2, 5, 1, 8, 3, 6, 4, 7).filter(e -> e % 2 == 0).map(e -> e * e).forEach(System.out::println);

		Stream.of("Anil", "Mukesh", "Suresh", "Sham").filter(e -> e.charAt(0) == 'S').forEach(System.out::println);

		Stream.of("Anil", "Mukesh", "Suresh", "Sham").filter(e -> e.charAt(0) == 'S').map(e -> e.concat("-Sunbeam"))
				.forEach(System.out::println);

	}

}
