package com.sunbeam;

public class Program06 {

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
		Runnable runnable = new MyRunnable();
		Thread t2 = new Thread(runnable);

		System.out.println("T1 State before Start - " + t1.getState());
		t1.start();
		t2.start();

		System.out.println("T1 State after Start - " + t1.getState());

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("T1 State after execution - " + t1.getState());

		System.out.println("Program Finished...");
	}

}
