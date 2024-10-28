package com.sunbeam.p1;

public class BankAccount {
	int accid;
	String name;
	double balance;

	public BankAccount() {
	}

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	public void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}
}
