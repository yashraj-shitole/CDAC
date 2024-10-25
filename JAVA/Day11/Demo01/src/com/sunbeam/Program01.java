package com.sunbeam;

import java.util.Vector;

public class Program01 {

	public static void main(String[] args) {
		Vector<Integer> v1 = new Vector<Integer>();
		for (int i = 1; i <= 20; i++)
			v1.add(i * 10);
		v1.add(110);
		System.out.println("capacity of the vector = " + v1.capacity());
		System.out.println("size of the vector = " + v1.size());
		System.out.println();

	}

}
