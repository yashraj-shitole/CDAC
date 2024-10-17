package com.sunbeam.p1;

class Test {
	int n1 = 10; // Field Initializer
	int n2;
	int n3;

	// Object Initializer-2
	{
		System.out.println("Object Initializer-2");
		n2 = 200;
	}

	// Object Initializer-1
	{
		System.out.println("Object Initializer-1");
		n2 = 20;
	}

	// Constructor
	public Test() {
		System.out.println("Constructor");
		n3 = 30;
	}

	void display() {
		System.out.println("n1 - " + n1);
		System.out.println("n2 - " + n2);
		System.out.println("n3 - " + n3);
	}
}

public class Program01 {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.display();

		Test t2 = new Test();
		t2.display();
	}

}
