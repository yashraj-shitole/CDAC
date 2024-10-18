package com.sunbeam.p1;

class Super {
	public void m1() {
		System.out.println("Super m1()");
	}

	public Number m2() {
		System.out.println("Super m2()");
		return 0;
	}

	public static void m3() {
		System.out.println("Super m3()");
	}
}

class Sub extends Super {
	@Override
	public Integer m2() {
		return 10;
	}

	@Override
	public void m1() {
		super.m1();
	}

	// static methods are not designed for overriding
	// @Override
//	public static void m3() {
//		System.out.println("Sub m3()");
//	}

}

public class Program01 {

	public static void main(String[] args) {
		Sub.m3();
	}

}
