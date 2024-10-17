package com.sunbeam.p2;

class Test {
	int n1;
	// final int n2 = 20; // OK
	final int n2;

	// Object initializer
	{
		// n2 = 20; // OK
	}

	public Test() {
		n2 = 20;
	}

	public void m1() {
		// n2 = 20; // NOT OK
		this = new Test();
	}
}

public class Program03 {
	public static void main(String[] args) {
		final Test t1;
		t1 = new Test();
		t1 = new Test();

	}

}
