package com.sunbeam.p3;

import java.util.Scanner;

enum AccountType {
	SAVINGS(3.5) {
		@Override
		public String toString() {
			return "Savings Account";
		}
	},
	CURRENT(1.2) {
		@Override
		public String toString() {
			return "Current Account";
		}
	},
	DMAT(0) {
		@Override
		public String toString() {
			return "D-mat Account";
		}
	};

	private double roi;

	private AccountType(double roi) {
		this.roi = roi;
	}

	public double getRoi() {
		return roi;
	}
}

public class Program01 {

	public static void main(String[] args) {
		AccountType[] arr = AccountType.values();
		for (AccountType e : arr)
			System.out.println(e.ordinal() + ". " + e);

		System.out.print("Enter the choice - ");
		int choice = new Scanner(System.in).nextInt();
		switch (arr[choice]) {
		case SAVINGS:
			break;

		// TODO

		}
	}

}
