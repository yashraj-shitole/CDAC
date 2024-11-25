package com.sunbeam;

public class Program04 {

	public static void main(String[] args) {
		String s1 = "sunbeam";
		String s2 = "sun";
		String s3 = s2 + "beam"; // new String("sunbeam");

		System.out.println("s1==s3 - " + (s1 == s3));
		System.out.println("s1.equals(s3) - " + (s1.equals(s3)));

	}

}
