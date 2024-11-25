package com.sunbeam;

class Singleton {
	// step-3 -> create a static reference of this class
	private static Singleton ref = null;

	// step-1 -> Make the ctor as private
	private Singleton() {
		System.out.println("Singleton Ctor called ");
	}

	// Step-2 -> Provide a static method that creates and
	// return the object of this class
	public static Singleton getInstance() {

		// step4-> check if the ref is null and if yes
		// create the object of this class and return the object
		if (ref == null)
			ref = new Singleton();
		return ref;
	}
}

public class Program01 {

	public static void main(String[] args) {
//		Singleton s1 = new Singleton();
//		Singleton s2 = new Singleton();
//		Singleton s3 = new Singleton();
//		Singleton s4 = new Singleton();

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();

	}

}
