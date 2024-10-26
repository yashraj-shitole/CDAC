package com.sunbeam;

// Marker Interface
interface I3 {

}

// Functional Interface
@FunctionalInterface
interface I4 {
	void m1(); // SAM (Single Abstract Method) Interface
}

//@FunctionalInterface // NOT a Functuional Interface
interface I5 {
	void m1();

	void m2();
}

@FunctionalInterface
interface I6 {
	void m1(); // SAM

	default void m2() {

	}

	static void m3() {

	}

	default void m4() {

	}

	static void m5() {

	}
}

class Program03 {
	public static void main(String[] args) {

	}
}