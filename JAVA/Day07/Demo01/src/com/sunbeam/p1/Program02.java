package com.sunbeam.p1;

interface I1 {

}

interface I2 {

}

interface I3 extends I1, I2 {

}

class C1 {

}

class C2 {

}

class C3 extends C1 implements I1, I2 {

}

public class Program02 {

	public static void main(String[] args) {
		// C3 extend C1 // OK
		// C3 extends C1,C2 // NOT OK
		// C3 implements I1// OK
		// C3 implements I1,I2// OK
		// C3 extends I1// NOT OK
		// C3 extends C1 implements I1// OK
		// C3 extends C1 implements I1,I2// OK

		// I3 extends C1 // NOT OK
		// I3 implements C1 // NOT OK
		// I3 implements I1 // NOT OK
		// I3 extends I1 // OK
		// I3 extends I1,I2 // OK
	}

}
