package com.sunbeam.p5;

public class Program {
	static boolean sunbeamstatus = false;

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
					sunbeamstatus = true;
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
						if (!sunbeamstatus)
							obj.wait();
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
