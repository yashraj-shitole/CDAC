eeeeepackage com.sunbeam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph {
	static class Edge{
		private int src, dest;
		private int wt;
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			wt = w;
		}
	}
	private final int INF = 999;
	private int vertexCount, edgeCount;
	private int adjmat[][];
	private List<Edge> edgelist;
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				adjmat[i][j] = INF;
			}
		}
		edgelist = new ArrayList<Graph.Edge>();
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
			adjmat[dest][src] = wt;			//in case od directed graph this line is not needed
			Edge e = new Edge(src, dest, wt);
			edgelist.add(e);
		}
	}
	
	public void kruskalMST() {
		// create list of Edges for mst
		List<Edge> mst = new ArrayList<Graph.Edge>();
		// sort all edges
		edgelist.sort((e1, e2) -> e1.wt - e2.wt);
		
		for(int i = 0  ; i < edgelist.size() ; i++) {
			// pick an edge from list with min wt
			Edge e = edgelist.get(i);
			// add edge into mst
			mst.add(e);
			// check if it is forming cycle
			if(hasCycle(mst)) {
				mst.remove(mst.size()-1);
			}
			if(mst.size() == vertexCount-1)
				break;
		}
		
		int wt = 0;
		for(Edge e : mst)
			wt += e.wt;
		System.out.println("MST weight : " + wt);
	}
	
	public boolean hasCycle(List<Edge> eList) {
		// consider parent of all vertices as -1
		int parent[] = new int[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			parent[i] = -1;
		for(Edge e : eList) {
			// find root of src and dest
			int sr = find(e.src, parent);
			int dr = find(e.dest, parent);
			// if src root == dest root then cycle is detected
			if(sr == dr)
				return true;
			// if src root != dest root
			union(sr, dr, parent);
		}
		return false;		
	}
	
	public int find(int v, int parent[]) {
		while(parent[v] != -1)
			v = parent[v];
		return v;
	}

	public void union(int sr, int dr, int parent[]){
		parent[sr] = dr;
	}
		
}

public class GraphBfsDfsAlgosMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		
		g.kruskalMST();;
		
		sc.close();
	}

}

/*
7
12
2 0 4
0 1 2
1 4 10
4 6 6
6 5 1
5 2 5
3 2 2
3 0 1
3 1 3
3 4 7
3 6 4
3 5 8

*/





