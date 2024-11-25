package com.sunbeam;

public class Program03 {

	public static void main(String[] args) {
		Time t1 = new Time(); // Default/Parameterless Ctor
		t1.displayTime();

		Time t2 = new Time(11, 45); // Paramaterized Ctor
		t2.displayTime();

		t1.acceptTime();
		t2.acceptTime();

	}

}
