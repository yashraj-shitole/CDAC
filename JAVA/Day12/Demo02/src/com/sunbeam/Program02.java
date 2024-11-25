package com.sunbeam;

interface I1 {
	default void m1() {
		System.out.println("I1::m1");
	}
}

interface I2 {
	default void m1() {
		System.out.println("I2::m1");
	}
}

class Test implements I1, I2 {

	public void m1() {
		I1.super.m1();
		I2.super.m1();
	}
}

class Program02 {
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.m1();
	}
}