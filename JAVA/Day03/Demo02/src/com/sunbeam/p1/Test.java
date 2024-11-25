package com.sunbeam.p1;

public class Test {
	private int num1;
	int num2; // package level private
	protected int num3;
	public int num4;

	public void displayTest() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
	}

}
