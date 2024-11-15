package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	public static void main(String[] args) {
		
		int v=5;
		
		
		ArrayList<Edge>[] graph=new ArrayList[v];
		
		for(int i=0;i<v;i++) {
			graph[i]=new ArrayList<>();
		}
		
		
		//for 0
		graph[0].add(new Edge(0, 1, 5));
		
		//for 1 
		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));
		
		//for 2
		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 4));
		
		//for 3
		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 2, 1));

		//for 4
		graph[4].add(new Edge(2, 1, 1));
		
		
		
		for(int i=0;i<graph[2].size();i++) {
			Edge e=graph[2].get(i);
			System.out.println("("+e.src+","+e.dest+") -> "+e.weight);
			
		}
		
		
		

	}
		
}

class Edge{
	
	int src;
	int dest;
	int weight;
	public Edge(int src, int dest, int weight) {
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}

