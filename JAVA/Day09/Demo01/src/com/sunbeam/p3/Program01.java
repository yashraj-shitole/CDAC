package com.sunbeam.p3;

// Bounded type parameter
class Box<T extends Number> {
	private T obj;

	public void setObj(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

}

public class Program01 {

	public static void main1(String[] args) {
		Box<Number> b1 = new Box<>();
		Box<Integer> b2 = new Box<>();
		Box<Double> b3 = new Box<>();
		// Box<String> b4 = new Box<>(); // NOT OK
		// Box<Date> b4 = new Box<>(); // NOT OK
		Box<Short> b4 = new Box<>();
	}

}
