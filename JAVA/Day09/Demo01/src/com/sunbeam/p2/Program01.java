package com.sunbeam.p2;

import java.util.Date;

// from java 1.5 onwards -> Type safety
class Box<T> {
	private T obj;

	public void setObj(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

}

public class Program01 {

	public static void main(String[] args) {
		Box<Integer> b1 = new Box<Integer>();
		Box<Integer> b2 = new Box<>(); // type inference
		Box<Integer> b3 = new Box();
		Box b4 = new Box(); // raw type
	}

	public static void main3(String[] args) {
		Box<Double> b1 = new Box<Double>();
		b1.setObj(new Double(10.12));
		// b1.setObj(new Integer(10)); // NOT OK

		Box<String> b2 = new Box<String>();
		b2.setObj(new String("sunbeam"));

		Box<Date> b3 = new Box<Date>();
		b3.setObj(new Date());

		Double d1 = b1.getObj();
		String s = b2.getObj();
		Date d = b3.getObj();
	}

	public static void main2(String[] args) {
		Box<Integer> b1 = new Box<Integer>();
		// b1.setObj(new String("10")); // NOT OK
		b1.setObj(new Integer(20));
		Integer i1 = b1.getObj();
		System.out.println("i1 = " + i1);

	}

	public static void main1(String[] args) {
		Box<Integer> b1 = new Box<Integer>();
		b1.setObj(new Integer(10));
		Integer i1 = b1.getObj();
		System.out.println("i1 = " + i1);

	}

}
