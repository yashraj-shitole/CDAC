package com.sunbeam;

import java.util.function.BinaryOperator;

public class Program03 {

	public static void doWork(BinaryOperator<Integer> op) {
		System.out.println("Result - " + op.apply(20, 10));
	}

	public static void main(String[] args) {

		// doWork((x, y) -> x + y);

		// Method reference
		// short hand implementation of lamda expressions
		doWork(Integer::sum);
	}

}
