package com.sunbeam;

public class Program09 {

	public static void main(String[] args) {
		String s1 = "sunbeam";
		String s2 = "sunbeam";
		// s2 = s2.concat("infotech");
		// s2 = s2 + "infotech";
		s2 = s2.concat("infotech").intern();
		String s3 = "sunbeaminfotech";

		System.out.println("s1==s2 - " + (s1 == s2));
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println("s2==s3 - " + (s2 == s3));
	}

}
