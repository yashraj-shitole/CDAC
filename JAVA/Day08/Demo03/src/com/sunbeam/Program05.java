package com.sunbeam;

import java.util.StringTokenizer;

public class Program05 {

	public static void main(String[] args) {
		// String name = "sunbeam infotech pune karad";
		// StringTokenizer stk = new StringTokenizer(name);

		// String name = "www.sunbeaminfo.com";
		// StringTokenizer stk = new StringTokenizer(name, ".");

		String name = "www.sunbeaminfo.com/placements";
		// StringTokenizer stk = new StringTokenizer(name, "./");
		StringTokenizer stk = new StringTokenizer(name, "./", true);

		while (stk.hasMoreTokens()) {
			String s = stk.nextToken();
			System.out.println(s);
		}
	}

}
