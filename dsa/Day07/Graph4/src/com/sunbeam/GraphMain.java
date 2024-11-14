package com.sunbeam;

import java.util.Scanner;

public class GraphMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vertex count : ");
		int v = sc.nextInt();
		
		Graph g = new Graph(v);
		
		g.accept(sc);
		g.print();

		sc.close();
	}

}


/*

6
7
0 1 7
0 2 4
0 3 8
1 2 9
1 4 5
3 4 6
3 5 2




*/









