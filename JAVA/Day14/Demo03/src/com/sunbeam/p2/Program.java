package com.sunbeam.p2;

public class Program {

	public static void delay() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BankAccount acc = new BankAccount(10000);

		class DepositThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					synchronized (acc) // acc is the monitor
					{ // lock acquired
						delay();
						acc.deposit(1000);
						System.out.println("Balance = " + acc.balance);
					} // release the lock
				}
			}
		}

		class WithdrawThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					synchronized (acc) {
						delay();
						acc.withdraw(1000);
						System.out.println("Balance = " + acc.balance);
					}
				}
			}
		}

		Thread dt = new DepositThread();
		Thread wt = new WithdrawThread();

		dt.start();
		wt.start();

		try {
			dt.join();
			wt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Progarm Finished, Final balance - " + acc.balance);
	}

}