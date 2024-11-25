package com.sunbeam.p3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program02 {
	public static void main(String[] args) {
		// JAVA NIO
		Path path = Paths.get("D:/Training/Courses/PG-AUG-24/KDAC/JAVA/Java/Day13");
		System.out.println("Is it a file ? - " + Files.isRegularFile(path));
		System.out.println("Is it a directory ? - " + Files.isDirectory(path));

		// Java IO
		File file = new File("D:/Training/Courses/PG-AUG-24/KDAC/JAVA/Java/Day13");
		System.out.println("Is it a file ? - " + file.isFile());
		System.out.println("Is it a directory ? - " + file.isDirectory());
		// file.mkdir();
		// file.delete();
	}
}
