package com.sunbeam;

import java.util.Scanner;

public class Time {
	// fields
	private int hr;
	private int min;

	public Time() {
	}

	public Time(int hr, int min) {
		this.hr = hr;
		this.min = min;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	// methods
	public void acceptTime() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the hrs - ");
		this.hr = sc.nextInt();
		System.out.println("Enter the mins - ");
		min = sc.nextInt();
	}

	public void displayTime() {
		System.out.println("Time = " + hr + " : " + min);
	}
}
