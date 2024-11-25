package com.sunbeam.p1;

class Test {
	int n1;
	// static int n2 = 20; // field initializer
	static int n2;

	// static block
	static {
		System.out.println("Static Block");
		n2 = 20;
	}
}

public class Program01 {
	public static void main(String[] args) {
		System.out.println("n2 = " + Test.n2);
	}

}
