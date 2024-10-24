package com.sunbeam.p5;

import java.util.Date;

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

	// unbounded type parameter -> Upper bound
	public static void display(Box<? extends Number> b) {
		System.out.println("value stored - " + b.getObj());
	}

	public static void main(String[] args) {
		Box<Integer> b1 = new Box<>();
		b1.setObj(new Integer(10));
		display(b1);

		Box<Double> b2 = new Box<>();
		b2.setObj(new Double(10.12));
		display(b2);

		Box<String> b3 = new Box<>();
		b3.setObj(new String("sunbeam"));
		// display(b3); // NOT OK

		Box<Date> b4 = new Box<>();
		b4.setObj(new Date());
		// display(b4);// NOT OK

		Box<? extends Number> b5 = new Box<Integer>(); // OK

	}

}
