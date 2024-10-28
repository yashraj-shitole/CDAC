package com.sunbeam.p1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {

	public static void write(Employee e) {
		try (FileOutputStream fos = new FileOutputStream("emp1.db", true)) {
			try (DataOutputStream dos = new DataOutputStream(fos)) {
				dos.writeInt(e.empid);
				dos.writeUTF(e.name);
				dos.writeDouble(e.salary);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void read() {

		try (FileInputStream fis = new FileInputStream("emp1.db")) {
			try (DataInputStream dis = new DataInputStream(fis)) {
				while (true) {
					int empid = dis.readInt();
					String name = dis.readUTF();
					double salary = dis.readDouble();
					Employee e = new Employee(empid, name, salary);
					System.out.println(e);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("Reading Employee Data Completed...");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// Employee e = new Employee(1, "Anil", 10000);
		// write(e);
		read();
	}

}
