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
		
		//g.DFSTraversal(0);
		//g.BFSTraversal(0);
		//g.singleSourcePathLength(1);
		
		g.DFSSpannigTree(0);
		g.BFSSpannigTree(0);

		sc.close();
	}

}


/*

6
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5




*/









