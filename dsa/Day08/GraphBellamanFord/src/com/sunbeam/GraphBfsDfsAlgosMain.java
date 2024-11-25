package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Graph {
	static class Edge{
		private int src, dest;
		private int wt;
		public Edge() {
			src = dest = wt = 0;
		}
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			wt = w;
		}
	}
	private final int INF = 999;
	private int vertexCount, edgeCount;
	private int adjmat[][];
	private List<Edge> edgeList;
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				adjmat[i][j] = INF;
			}
		}
		edgeList = new ArrayList<Graph.Edge>();
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjmat[src][dest] = wt;
			//adjmat[dest][src] = wt;			//in case od directed graph this line is not needed
			Edge e = new Edge(src, dest, wt);
			edgeList.add(e);
		}
	}
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print(adjmat[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void bellamanFord(int start) {
		// keep track of distances of all vertices - initially all distances are INF and distance of start vertex is 0
		int dist[] = new int[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			dist[i] = INF;
		dist[start] = 0;
		
		// V-1 times relax all the edges of graph
		for(int i = 1 ; i < vertexCount ; i++) {
			// for each edge u-v, update dist of v
			for(Edge e : edgeList) {
				int u = e.src, v = e.dest, w = e.wt;
				if(dist[u] != INF && (dist[u] + w) < dist[v])
					dist[v] = dist[u] + w;
			}
		}
		
		// for each edge u-v, update dist of v
		for(Edge e : edgeList) {
			int u = e.src, v = e.dest, w = e.wt;
			if(dist[u] != INF && (dist[u] + w) < dist[v]) {
				System.out.println("Graph has -ve edge cycle");
				return;
			}
		}
		
		// print all shortest distances
		System.out.println("Distance from " + start + "Vertex  : ");
		for(int v = 0 ; v < vertexCount ;v++)
			System.out.println("to " + v + " : " + dist[v]);
	}
	
		
}

public class GraphBfsDfsAlgosMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		g.print();
		
		g.bellamanFord(0);
		sc.close();
	}

}

/*
5
7
0 1 6
0 3 5
3 1 -2
1 2 -1
3 2 4
3 4 3
2 4 3

*/





