package com.sunbeam;

public class Program08 {

	public static void main(String[] args) {
		String s1 = "sunbeam";
		String s2 = new String("sunbeam");
		String s3 = s2.intern();

		System.out.println("s1==s3 - " + (s1 == s3));

	}

}
