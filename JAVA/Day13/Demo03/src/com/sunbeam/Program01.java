package com.sunbeam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Program01 {
	public static int menu(Scanner sc) {
		System.out.println("0. EXIT");
		System.out.println("1. Add Product");
		System.out.println("2. Display All products");
		System.out.println("3. Delete a Product");
		System.out.println("4. Find a Product");
		System.out.println("5. Display all products with price high to low");
		System.out.print("Enter the choice - ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		List<Product> products = loadProducts();
		Scanner sc = new Scanner(System.in);
		Product p;
		int choice;
		while ((choice = menu(sc)) != 0) {
			switch (choice) {
			case 1:
				p = new Product();
				p.accept(sc);
				products.add(p);
				break;
			case 2:
				products.forEach(System.out::println);
				break;
			case 3:
				System.out.println("Enter Product id to delete - ");
				System.out.println("Product deleted = " + products.remove(new Product(sc.nextInt())));
				break;
			case 4:
				System.out.println("Enter Product id to search - ");
				p = new Product(sc.nextInt());
				int index = products.indexOf(p);
				if (index != -1)
					System.out.println(products.get(index));
				else
					System.out.println("Product not found...");

				break;
			case 5:
				products.sort((p1, p2) -> Double.compare(p2.price, p1.price));
				products.forEach(System.out::println);
				products.sort((p1, p2) -> p1.pid - p2.pid);
				break;
			default:
				System.out.println("Wrong choice...");
				break;
			}
		}
		saveProducts(products);
	}

	private static void saveProducts(List<Product> products) {
		try (FileOutputStream fos = new FileOutputStream("products.db")) {
			try (BufferedOutputStream bos = new BufferedOutputStream(fos)) {
				try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
					oos.writeObject(products);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Product> loadProducts() {
		try (FileInputStream fis = new FileInputStream("products.db")) {
			try (BufferedInputStream bis = new BufferedInputStream(fis)) {
				try (ObjectInputStream ois = new ObjectInputStream(bis)) {
					List<Product> products = (List<Product>) ois.readObject();
					return products;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
