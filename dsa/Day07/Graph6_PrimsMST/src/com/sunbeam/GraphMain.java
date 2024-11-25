package com.sunbeam;

import java.util.Scanner;

public class GraphMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vertex count : ");
		int v = sc.nextInt();
		
		Graph g = new Graph(v);
		
		g.accept(sc);
		//g.print();
		
		g.primsMST(2);

		sc.close();
	}

}


/*

7
12
0 1 2
1 4 10
4 6 6
6 5 1
5 2 5
2 0 4
3 0 1
3 1 3
3 4 7
3 6 4
3 5 8
3 2 2






*/









