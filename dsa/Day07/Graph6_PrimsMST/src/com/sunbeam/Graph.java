package com.sunbeam;

import java.util.Scanner;

public class Graph {
	private final int INF = 999;
	private int edgeCount, vertexCount;
	private int adjmat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
		for(int u = 0 ; u < vertexCount ; u++)
			for(int v = 0 ; v < vertexCount ; v++)
				adjmat[u][v] = INF;
	}
	
	public void accept(Scanner sc) {
		System.out.print("No of edges : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges : (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjmat[src][dest] = wt;
			adjmat[dest][src] = wt;			// comment this line for directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				System.out.print(" " + adjmat[u][v]);
			}
			System.out.println();
		}
	}
	
	public int findMinKeyVertex(int key[], boolean mst[]) {
		int minKey = INF, minKeyVertex = -1;
		for(int i = 0 ; i < vertexCount ; i++) {
			if(!mst[i] && key[i] < minKey) {
				minKey = key[i];
				minKeyVertex = i;
			}
		}
		return minKeyVertex;
	}
	
	public void primsMST(int start) {
		//0. create array to track MST, parent and key
		boolean mst[] = new boolean[vertexCount];
		int parent[] = new int[vertexCount];
		int key[] = new int[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			mst[i] = false;
			parent[i] = -1;
			key[i] = INF;
		}
		//1. mark key of start vertex as 0
		key[start] = 0;
		//2. while all vertices are not added into MST, repeat below step
		int count = 0;
		while(count < vertexCount) {
			//3. choose minimum key vertex which is not added into MST
			int u = findMinKeyVertex(key, mst);
			//4. add vertex into MST
			mst[u] = true;
			//5. increment count
			count++;
			//6. update keys and parents of adjcent vertices which are not added into MST
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!mst[v] && adjmat[u][v] != INF && adjmat[u][v] < key[v]) {
					key[v] = adjmat[u][v];
					parent[v] = u;
				}
			}
		}
		int wt = 0;
		System.out.print("MST : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print("(" + parent[i] + "," + i + ")");
			wt += key[i];
		}
		System.out.println("\nWeight : " + wt);
	}
}















