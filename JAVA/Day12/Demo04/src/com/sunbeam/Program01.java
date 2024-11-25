package com.sunbeam;

import java.util.function.BinaryOperator;

public class Program01 {

	// Assume it like sort or forEach
	public static void doWork(BinaryOperator<Integer> op) {
		System.out.println("Result - " + op.apply(20, 10));
	}

	public static void main(String[] args) {
		// non capturing lambda expressions
		doWork((x, y) -> x + y);

		doWork((x, y) -> x - y);

		doWork((x, y) -> x * y);
	}

}
