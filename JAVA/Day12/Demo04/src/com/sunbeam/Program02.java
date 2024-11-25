package com.sunbeam;

import java.util.function.BinaryOperator;

public class Program02 {

	public static void doWork(BinaryOperator<Integer> op) {
		System.out.println("Result - " + op.apply(20, 10));
	}

	public static void main(String[] args) {
		int z = 5; // it should be final or effectively final variables

		// capturing lambda
		doWork((x, y) -> x + y + z);

		doWork((x, y) -> x - y - z);

		doWork((x, y) -> x * y * z);
	}

}
