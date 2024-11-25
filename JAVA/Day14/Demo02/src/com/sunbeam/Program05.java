package com.sunbeam;

public class Program05 {

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
					delay(200);
					System.out.println("MyThread = " + i);
				}
			}
		}

		// way-2
		class MyRunnable implements Runnable {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					delay(200);
					System.out.println("MyRunnable = " + i);
				}
			}
		}

		Thread t1 = new MyThread();
		Runnable runnable = new MyRunnable();
		Thread t2 = new Thread(runnable);

		t1.setPriority(1); // hightest Priority
		t2.setPriority(10); // Lowest Priority
		t1.start();
		t2.start();

		System.out.println("Main Thread Priority - " + Thread.currentThread().getPriority());
		// System.out.println("T1 Thread Priority - " + t1.getPriority());
		// System.out.println("T2 Thread Priority - " + t2.getPriority());

//		for (int i = 1; i <= 5; i++) {
//			delay(1000);
//			System.out.println("Main = " + i);
//		}

		System.out.println("Program Finished...");
	}

}
