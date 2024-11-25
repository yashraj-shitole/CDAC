package com.sunbeam.p1;

enum ArithmeticOperations {
	EXIT, ADD, SUB, MUL, DIV
}

public class Program01 {

	public static void main(String[] args) {
		ArithmeticOperations[] arr = ArithmeticOperations.values();
		for (ArithmeticOperations e : arr)
			System.out.println(e.ordinal() + ". " + e.name());
	}

	public static void main1(String[] args) {
		System.out.println("Name = " + ArithmeticOperations.ADD.name());
		System.out.println("Ordinal = " + ArithmeticOperations.ADD.ordinal());
	}

}
