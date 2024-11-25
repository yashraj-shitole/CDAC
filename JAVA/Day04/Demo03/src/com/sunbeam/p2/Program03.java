package com.sunbeam.p2;

class Test {
	int n1 = 10;
	static int n2 = 20;

	// nonstatic
	void method1() {
		System.out.println(n1);
		System.out.println(n2);
	}

	// static
	static void method2() {
		// System.out.println(n1); // NOT OK
		System.out.println(n2); // OK
	}
}

public class Program03 {
	public static void main(String[] args) {
		Test.method2();
	}

}
