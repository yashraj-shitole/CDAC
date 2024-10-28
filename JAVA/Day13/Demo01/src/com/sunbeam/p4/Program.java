package com.sunbeam.p4;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Program {

	public static void write(Employee e) {
		try (PrintStream pout = new PrintStream("emp4.db")) {
			pout.println(e.empid + "," + e.name + "," + e.salary);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Employee e = new Employee(1, "Anil", 10000);
		write(e);
	}

}
