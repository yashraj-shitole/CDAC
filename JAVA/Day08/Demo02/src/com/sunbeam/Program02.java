package com.sunbeam;

public class Program02 {

	public static void main(String[] args) {
		String s1 = "sunbeam";
		String s2 = "sunbeam";

		String s3 = new String("sunbeam");
		String s4 = new String("sunbeam");

		System.out.println("s1==s2 - " + (s1 == s2));
		System.out.println("s3==s4 - " + (s3 == s4));
		System.out.println("s1==s3 - " + (s1 == s3));

		System.out.println("s3.equals(s4) - " + (s3.equals(s4)));
		System.out.println("s1.equals(s3) - " + (s1.equals(s3)));

	}

}
