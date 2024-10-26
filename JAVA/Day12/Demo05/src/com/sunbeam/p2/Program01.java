package com.sunbeam.p2;

class Outer {

	int n1 = 10;
	static int n2 = 20;

	static class Inner {
		int n3 = 30;
		static int n4 = 40;

		public void m1() {
			Outer o1 = new Outer();
			System.out.println(o1.n1);// OK
			// System.out.println(n1);// NOT OK
			System.out.println(n2);
			System.out.println(n3);
			System.out.println(n4);
		}

		public static void m2() {
			Outer o1 = new Outer();
			System.out.println(o1.n1);// OK
			// System.out.println(n1); // NOT OK
			System.out.println(n2);
			// System.out.println(n3) // NOT OK;
			System.out.println(n4);
		}

	}

}

public class Program01 {

	public static void main(String[] args) {
		Outer.Inner i1 = new Outer.Inner();
	}

}
