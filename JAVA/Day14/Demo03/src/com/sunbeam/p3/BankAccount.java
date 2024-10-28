package com.sunbeam.p3;

public class BankAccount {
	int accid;
	String name;
	double balance;

	public BankAccount() {
	}

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public synchronized void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	public synchronized void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}
}
