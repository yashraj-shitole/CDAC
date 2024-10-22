package com.sunbeam;

public class Program02 {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("sunbeam");
		StringBuilder sb2 = new StringBuilder("sunbeam");

		System.out.println("sb1==sb2 - " + (sb1 == sb2));
		System.out.println("sb1.equals(sb2) - " + (sb1.equals(sb2)));

	}

}
