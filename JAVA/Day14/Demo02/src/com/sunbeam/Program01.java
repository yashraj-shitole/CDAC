package com.sunbeam;

import java.io.IOException;

public class Program01 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		try {
			Process process = rt.exec("notepad");
			int status = process.waitFor();
			System.out.println("status = " + status);
			System.out.println("Program Finished..");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
