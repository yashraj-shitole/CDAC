package com.sunbeam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	static class Adjacent{
		private int dest;
		private int wt;
		public Adjacent(int d, int w) {
			dest = d;
			wt = w;
		}
	}
	private int edgeCount, vertexCount;
	private List<Adjacent> adjlist[];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjlist = new List[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			adjlist[i] = new LinkedList<Adjacent>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("No of edges : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges : (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjlist[src].add(new Adjacent(dest, wt));
			adjlist[dest].add(new Adjacent(src, wt));			// comment this line for directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			System.out.print(u + " : ");
			for(Adjacent v : adjlist[u])
				System.out.print(" " + v.dest + "(" + v.wt + ")");
			System.out.println();
		}
	}
}















