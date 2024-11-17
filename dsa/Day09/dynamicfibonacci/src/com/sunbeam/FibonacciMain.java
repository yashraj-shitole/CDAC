package com.sunbeam;

public class FibonacciMain {
	private static int count = 0;
	public static int recFib(int n) {
		count++;
		if(n == 1 || n == 2)
			return 1;
		int res = recFib(n-1) + recFib(n-2);
		return res;
	}
	
	public static int memFib(int n, int[] terms) {
		count++;
		if(terms[n] != 0)
			return terms[n];
		if(n == 1 || n == 2) {
			terms[n] = 1;
			return terms[n];
		}
		terms[n] = memFib(n-1, terms) + memFib(n-2, terms);
		return terms[n];
	}
	
	public static int memFib(int n) {
		int[] terms = new int[n+1];
		int res = memFib(n, terms);
		return res;
	}
	
	public static int dpFib(int n) {
		count++;
		int[] terms = new int[n+1];
		terms[1] = 1;
		terms[2] = 1;
		for(int i=3; i<=n; i++)
			terms[i] = terms[i-1] + terms[i-2];
		return terms[n];
	}

	public static void main(String[] args) {
		int res, n = 30;
		res = recFib(n);
		System.out.println("Rec Result: " + res + " with Fn Calls: " + count);
		count = 0;
		res = memFib(n);
		System.out.println("Mem Result: " + res + " with Fn Calls: " + count);
		count = 0;
		res = dpFib(n);
		System.out.println(" DP Result: " + res + " with Fn Calls: " + count);
	}

}
