package com.sunbeam;

import java.util.Optional;
import java.util.stream.Stream;

public class Program05 {

	public static void main(String[] args) {
		Optional<Integer> op = Stream.of(1, 2, 3, 4, 5).reduce((x, y) -> x + y);

		System.out.println("Result = " + op);

		op = Optional.empty();
		// System.out.println("Result = " + op.isPresent());

		op.ifPresent(e -> System.out.println("Result with ifPresent = " + e));

		System.out.println("Result with orElse= " + op.orElse(0));

		// System.out.println("Result with orElse= " + op.orElseThrow(() -> new
		// RuntimeException()));
		System.out.println("Result with orElse= " + op.orElseThrow(RuntimeException::new));
	}

}
