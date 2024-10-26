package com.sunbeam.p3;

class Outer {

	int n1 = 10;
	static int n2 = 20;

	class Inner {
		int n3 = 30;
		// static int n4 = 40; //NOT OK

		public void m1() {
			System.out.println(n1);// OK
			System.out.println(n2);
			System.out.println(n3);
		}

		// public static void m2() {} // NOT OK
	}

}

public class Program01 {

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i1 = o.new Inner();
	}

}
