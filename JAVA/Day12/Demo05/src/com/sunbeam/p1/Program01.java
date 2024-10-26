package com.sunbeam.p1;

public class Program01 {

	public static void m1() {
		int n2 = 20;
		// n2 = 40;

		class Local {
			int n1;
			// static int n2; // NOT OK

			public void m1() {
				System.out.println(n1);
				// to access local variable of the enclosing method
				// the variable should be final or effectively final
				System.out.println(n2);
			}

			// public static void m2() {} // NOT OK
		}

		Local l1 = new Local();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
