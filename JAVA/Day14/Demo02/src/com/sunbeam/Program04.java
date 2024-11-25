package com.sunbeam;

public class Program04 {

	public static void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// way-1
		class MyThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					delay(1000);
					System.out.println("MyThread = " + i);
				}
			}
		}

		// way-2
		class MyRunnable implements Runnable {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					delay(1000);
					System.out.println("MyRunnable = " + i);
				}
			}
		}

		Thread t1 = new MyThread();
		t1.start();

		Runnable runnable = new MyRunnable();
		Thread t2 = new Thread(runnable);
		t2.setDaemon(true);
		t2.start();

		for (int i = 1; i <= 5; i++) {
			delay(1000);
			System.out.println("Main = " + i);
		}

		System.out.println("Program Finished...");
	}

}
