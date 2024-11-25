package com.sunbeam;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	int pid;
	String name;
	double price;

	public Product() {
	}

	public Product(int pid) {
		this.pid = pid;
	}

	public Product(int pid, String name, double price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}

	public void accept(Scanner sc) {
		System.out.print("Enter the product id - ");
		pid = sc.nextInt();
		System.out.print("Enter the product name - ");
		name = sc.next();
		System.out.print("Enter the price - ");
		price = sc.nextDouble();

	}

	@Override
	public int hashCode() {
		return Objects.hash(pid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return pid == other.pid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}

}
