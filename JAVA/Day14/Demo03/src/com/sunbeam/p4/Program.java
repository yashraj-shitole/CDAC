package com.sunbeam.p4;

public class Program {
	public static void delay() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Object obj = new Object();

		class SunbeamThread extends Thread {
			@Override
			public void run() {
				String name = "Sunbeam";
				synchronized (obj) {
					for (int i = 0; i < name.length(); i++) {
						delay();
						System.out.print(name.charAt(i));
					}
					obj.notify();
				}

			}
		}

		class InfotechThread extends Thread {
			@Override
			public void run() {
				String name = "Infotech";
				synchronized (obj) {
					try {
						// obj.wait();
						obj.wait(15000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (int i = 0; i < name.length(); i++) {
						delay();
						System.out.print(name.charAt(i));
					}
				}

			}
		}

		Thread st = new SunbeamThread();
		Thread it = new InfotechThread();

		it.start();
		st.start();

		try {
			st.join();
			it.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
