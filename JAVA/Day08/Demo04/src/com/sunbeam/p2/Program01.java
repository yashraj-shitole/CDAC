package com.sunbeam.p2;

enum AccountType {
	SAVINGS(3.5), CURRENT(1.2), DMAT(0);

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
			System.out.println(e.ordinal() + ". " + e.name() + " - " + e.getRoi());
	}

}
