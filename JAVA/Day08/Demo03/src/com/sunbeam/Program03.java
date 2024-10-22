package com.sunbeam;

public class Program03 {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("sunbeam");
		StringBuilder sb2 = sb1;

		sb2.append("infotech");

		System.out.println("sb1==sb2 - " + (sb1 == sb2));
		System.out.println("sb1 = " + sb1);
		System.out.println("sb2 = " + sb2);

	}

}
